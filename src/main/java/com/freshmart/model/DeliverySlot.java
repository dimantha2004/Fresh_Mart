package com.freshmart.model;

/** Delivery time slots a customer can choose from (assumed three fixed daily windows). */
public enum DeliverySlot {
    MORNING("Morning (08:00 - 12:00)"),
    AFTERNOON("Afternoon (12:00 - 16:00)"),
    EVENING("Evening (16:00 - 20:00)");

    private final String displayName;

    DeliverySlot(String displayName) { this.displayName = displayName; }

    @Override
    public String toString() { return displayName; }
}
