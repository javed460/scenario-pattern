package com.example.scenariopattern.controller;

import com.example.scenariopattern.domain.OrderEvents;
import com.example.scenariopattern.dto.OrderDTO;
import com.example.scenariopattern.dto.OrderResponseDTO;
import com.example.scenariopattern.scenario.ScenarioExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final ScenarioExecutor scenarioExecutor;

    @PostMapping("/create")
    public OrderResponseDTO createOrder(@RequestBody OrderDTO orderDTO) {
        List<OrderEvents> orderEvents = scenarioExecutor.executeOrderScenario(orderDTO);
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

        List<String> events = orderEvents.stream()
                .map(OrderEvents::name)
                .collect(Collectors.toList());

        orderResponseDTO.setEvents(events);
        return orderResponseDTO;
    }
}
