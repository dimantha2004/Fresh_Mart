package com.freshmart.model.state;

import com.freshmart.model.OrderStatus;

/** Final state. */
public record DeliveredState() implements OrderState {
    @Override
    public OrderStatus status() { return OrderStatus.DELIVERED; }
}
