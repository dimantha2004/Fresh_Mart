package com.freshmart.model.state;

import com.freshmart.model.OrderStatus;
import java.util.Optional;

/** Initial state. The order can be confirmed or cancelled. */
public record PlacedState() implements OrderState {
    @Override
    public OrderStatus status() { return OrderStatus.PLACED; }

    @Override
    public Optional<OrderStatus> nextStatus() { return Optional.of(OrderStatus.CONFIRMED); }

    @Override
    public OrderState next() { return new ConfirmedState(); }

    @Override
    public boolean canCancel() { return true; }

    @Override
    public OrderState cancel() { return new CancelledState(); }
}
