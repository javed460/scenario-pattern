package com.example.scenariopattern.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ScenarioEvents {
    private List<OrderEvents> orderEventsList = new ArrayList<>();

    public static ScenarioEvents scenarioEvents() {
        return new ScenarioEvents();
    }

    public ScenarioEvents addEvents(List<OrderEvents> orderEvents) {
        orderEventsList.addAll(orderEvents);
        return this;
    }

    public static ScenarioEvents noEvents() {
        return new ScenarioEvents();
    }
}

