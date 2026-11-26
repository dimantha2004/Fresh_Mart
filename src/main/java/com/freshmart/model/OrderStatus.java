package com.freshmart.model;

/**
 * Order life cycle: PENDING -> CONFIRMED -> PREPARING -> OUT_FOR_DELIVERY -> DELIVERED.
 * CANCELLED can only be reached before OUT_FOR_DELIVERY (coursework cancellation rule).
 */
public enum OrderStatus {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    PREPARING("Preparing"),
    OUT_FOR_DELIVERY("Out for Delivery"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled");

    private final String displayName;

    OrderStatus(String displayName) { this.displayName = displayName; }

    public boolean isCancellable() {
        return this == PENDING || this == CONFIRMED || this == PREPARING;
    }

    public boolean isFinal() { return this == DELIVERED || this == CANCELLED; }

    /** The next status in the normal delivery workflow, or null when the order is finished. */
    public OrderStatus next() {
        return switch (this) {
            case PENDING -> CONFIRMED;
            case CONFIRMED -> PREPARING;
            case PREPARING -> OUT_FOR_DELIVERY;
            case OUT_FOR_DELIVERY -> DELIVERED;
            case DELIVERED, CANCELLED -> null;
        };
    }

    public boolean canMoveTo(OrderStatus target) {
        return target == CANCELLED ? isCancellable() : target == next();
    }

    @Override
    public String toString() { return displayName; }
}
