package com.freshmart.model.state;

import com.freshmart.exception.ValidationException;
import com.freshmart.model.OrderStatus;

import java.io.Serializable;
import java.util.Optional;

/**
 * STATE pattern: one object for each stage of the order lifecycle. The current state decides which
 * transitions are allowed. By default a state allows nothing, so each concrete state only
 * overrides the moves that are legal from it.
 */
public interface OrderState extends Serializable {

    /** The state object for a saved status. */
    static OrderState of(OrderStatus status) {
        return switch (status) {
            case PLACED -> new PlacedState();
            case CONFIRMED -> new ConfirmedState();
            case PREPARING -> new PreparingState();
            case OUT_FOR_DELIVERY -> new OutForDeliveryState();
            case DELIVERED -> new DeliveredState();
            case CANCELLED -> new CancelledState();
        };
    }

    OrderStatus status();

    /** The status that follows in the delivery workflow, or empty when the order is finished. */
    default Optional<OrderStatus> nextStatus() { return Optional.empty(); }

    /** Moves one step forward. */
    default OrderState next() {
        throw new ValidationException("An order that is " + status() + " cannot move forward.");
    }

    default boolean canCancel() { return false; }

    default OrderState cancel() {
        throw new ValidationException("An order that is " + status() + " cannot be cancelled.");
    }
}
