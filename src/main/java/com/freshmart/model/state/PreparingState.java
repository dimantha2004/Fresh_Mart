package com.freshmart.model.state;

import com.freshmart.model.OrderStatus;
import java.util.Optional;

/** Being packed. This is the last state from which it can be cancelled. */
public record PreparingState() implements OrderState {
    @Override
    public OrderStatus status() { return OrderStatus.PREPARING; }

    @Override
    public Optional<OrderStatus> nextStatus() { return Optional.of(OrderStatus.OUT_FOR_DELIVERY); }

    @Override
    public OrderState next() { return new OutForDeliveryState(); }

    @Override
    public boolean canCancel() { return true; }

    @Override
    public OrderState cancel() { return new CancelledState(); }
}
