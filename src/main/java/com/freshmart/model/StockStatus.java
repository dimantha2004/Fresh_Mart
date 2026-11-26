package com.freshmart.model;

/** Stock status is derived from the quantity so the two can never contradict each other. */
public enum StockStatus {
    IN_STOCK("In Stock"),
    LOW_STOCK("Low Stock"),
    OUT_OF_STOCK("Out of Stock");

    /** Assumption: 10 units or fewer (but more than zero) counts as Low Stock. */
    public static final int LOW_STOCK_THRESHOLD = 10;

    private final String displayName;

    StockStatus(String displayName) { this.displayName = displayName; }

    public static StockStatus forQuantity(int quantity) {
        if (quantity <= 0) return OUT_OF_STOCK;
        if (quantity <= LOW_STOCK_THRESHOLD) return LOW_STOCK;
        return IN_STOCK;
    }

    /** A product can be ordered while any units remain (In Stock or Low Stock). */
    public boolean isOrderable() { return this != OUT_OF_STOCK; }

    @Override
    public String toString() { return displayName; }
}
