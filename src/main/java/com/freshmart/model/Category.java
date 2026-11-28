package com.freshmart.model;

/**
 * The four product categories. Their fees and rates are not stored here: they are interchangeable
 * pricing strategies (see the {@code pricing} package).
 */
public enum Category {
    VEGETABLES("Vegetables"),
    FRUITS("Fruits"),
    DAIRY("Dairy"),
    HOUSEHOLD_ESSENTIALS("Household Essentials");

    private final String displayName;

    Category(String displayName) { this.displayName = displayName; }

    @Override
    public String toString() { return displayName; }
}
