package com.freshmart.model.state;

import com.freshmart.model.OrderStatus;
import java.util.Optional;

/** On its way. It can only be delivered; cancellation is no longer allowed. */
public record OutForDeliveryState() implements OrderState {
    @Override
    public OrderStatus status() { return OrderStatus.OUT_FOR_DELIVERY; }

    @Override
    public Optional<OrderStatus> nextStatus() { return Optional.of(OrderStatus.DELIVERED); }

    @Override
    public OrderState next() { return new DeliveredState(); }
}
