package com.example.scenariopattern.scenario;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.example.scenariopattern.domain.OrderEvents.START_SHIPPING;
import static com.example.scenariopattern.domain.OrderScenario.anOrderScenario;
import static com.example.scenariopattern.domain.ScenarioEvents.scenarioEvents;
import static java.util.Arrays.asList;

@Getter
@ToString
@Component
public class OrderScenarioInitializer {
    private List<OrderScenarioManager> orderScenarios = new ArrayList<>();

    @PostConstruct
    private void registerOrderScenarios() {
        registerScenario()
                .when(
                        anOrderScenario()
                                .isAddedToCart(true)
                                .isConfirmed(true)
                )
                .then(
                        scenarioEvents()
                                .addEvents(asList(START_SHIPPING))
                );

    }

    private OrderScenarioManager registerScenario() {
        OrderScenarioManager orderScenarioManager = new OrderScenarioManager();
        orderScenarios.add(orderScenarioManager);
        return orderScenarioManager;
    }
}
