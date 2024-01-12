package com.example.scenariopattern.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class OrderScenario {
    private boolean addedToCart;
    private boolean confirmed;

    public static OrderScenario anOrderScenario() {
        return new OrderScenario();
    }

    public OrderScenario isAddedToCart(boolean isAddedToCart) {
        this.addedToCart = isAddedToCart;
        return this;
    }

    public OrderScenario isConfirmed(boolean isConfirmed) {
        this.confirmed = isConfirmed;
        return this;
    }
}
