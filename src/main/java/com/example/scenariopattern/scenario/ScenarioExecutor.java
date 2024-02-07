package com.example.scenariopattern.scenario;

import com.example.scenariopattern.domain.OrderEvents;
import com.example.scenariopattern.domain.OrderScenario;
import com.example.scenariopattern.domain.ScenarioEvents;
import com.example.scenariopattern.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.scenariopattern.domain.ScenarioEvents.noEvents;

@Component
@RequiredArgsConstructor
public class ScenarioExecutor {
    private final OrderScenarioInitializer orderScenarioInitializer;

    public List<OrderEvents> executeOrderScenario (OrderDTO orderDTO) {
        OrderScenario incomingOrder = new OrderScenario();
        BeanUtils.copyProperties(orderDTO, incomingOrder);

        List<OrderScenarioManager> orderScenarios = orderScenarioInitializer.getOrderScenarios();

        ScenarioEvents scenarioEvents = orderScenarios.stream()
                .filter(manager -> manager.matchScenario(incomingOrder))
                .map(OrderScenarioManager::getScenarioEvents)
                .findFirst()
                .orElse(noEvents());

        List<OrderEvents> orderEventsList = scenarioEvents.getOrderEventsList();
        return orderEventsList;
    }
}
