package com.example.scenariopattern.scenario;

import com.example.scenariopattern.domain.OrderScenario;
import com.example.scenariopattern.domain.ScenarioEvents;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderScenarioManager {
    private OrderScenario orderScenario;
    private ScenarioEvents scenarioEvents;

    public OrderScenarioManager when(OrderScenario orderScenario) {
        this.orderScenario = orderScenario;
        return this;
    }

    public OrderScenarioManager then(ScenarioEvents scenarioEvents) {
        this.scenarioEvents = scenarioEvents;
        return this;
    }

    public boolean matchScenario(OrderScenario incomingOrderScenario) {
        return incomingOrderScenario.isAddedToCart() == orderScenario.isAddedToCart() &&
                incomingOrderScenario.isConfirmed() == orderScenario.isConfirmed();
    }

}
