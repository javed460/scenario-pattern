package com.example.scenariopattern.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDTO {
    private boolean addedToCart;
    private boolean confirmed;
}