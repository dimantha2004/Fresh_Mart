package com.freshmart.model;

/**
 * The name of each stage, used for display and filtering. The rules about moving between stages
 * belong to the State pattern classes in {@code model.state}.
 */
public enum OrderStatus {
    PLACED("Placed"),
    CONFIRMED("Confirmed"),
    PREPARING("Preparing"),
    OUT_FOR_DELIVERY("Out for Delivery"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled");

    private final String displayName;

    OrderStatus(String displayName) { this.displayName = displayName; }

    @Override
    public String toString() { return displayName; }
}
