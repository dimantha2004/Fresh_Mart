package com.freshmart.model.state;

import com.freshmart.model.OrderStatus;
import java.util.Optional;

/** Accepted by the shop. The order can be prepared or cancelled. */
public record ConfirmedState() implements OrderState {
    @Override
    public OrderStatus status() { return OrderStatus.CONFIRMED; }

    @Override
    public Optional<OrderStatus> nextStatus() { return Optional.of(OrderStatus.PREPARING); }

    @Override
    public OrderState next() { return new PreparingState(); }

    @Override
    public boolean canCancel() { return true; }

    @Override
    public OrderState cancel() { return new CancelledState(); }
}
