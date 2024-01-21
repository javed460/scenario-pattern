package com.example.scenariopattern.controller;

import com.example.scenariopattern.domain.OrderEvents;
import com.example.scenariopattern.dto.OrderDTO;
import com.example.scenariopattern.scenario.ScenarioExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final ScenarioExecutor scenarioExecutor;

    @PostMapping("/create")
    public List<OrderEvents> createOrder(@RequestBody OrderDTO orderDTO) {
        List<OrderEvents> orderEvents = scenarioExecutor.executeOrderScenario(orderDTO);
        return orderEvents;
    }
}
