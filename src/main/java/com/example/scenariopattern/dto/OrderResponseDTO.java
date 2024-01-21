package com.example.scenariopattern.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderResponseDTO {
    private List<String> events;
}
