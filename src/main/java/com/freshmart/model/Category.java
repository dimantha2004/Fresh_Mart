package com.freshmart.model;

import java.math.BigDecimal;

/**
 * The four product categories from Table 1 of the coursework brief.
 * Each constant carries its own delivery fee, minimum order value, discount rate and tax rate,
 * so the billing code never needs a switch statement over categories.
 */
public enum Category {
    VEGETABLES("Vegetables", "300", "2000", "0.05", "0.05"),
    FRUITS("Fruits", "350", "2500", "0.05", "0.05"),
    DAIRY("Dairy", "400", "3000", "0.08", "0.08"),
    HOUSEHOLD_ESSENTIALS("Household Essentials", "500", "4000", "0.10", "0.10");

    private final String displayName;
    private final BigDecimal deliveryFee;
    private final BigDecimal minimumOrderValue;
    private final BigDecimal discountRate;
    private final BigDecimal taxRate;

    Category(String displayName, String deliveryFee, String minimumOrderValue, String discountRate, String taxRate) {
        this.displayName = displayName;
        // String constructors keep the values exact (new BigDecimal(0.05) would not be).
        this.deliveryFee = new BigDecimal(deliveryFee);
        this.minimumOrderValue = new BigDecimal(minimumOrderValue);
        this.discountRate = new BigDecimal(discountRate);
        this.taxRate = new BigDecimal(taxRate);
    }

    public BigDecimal getDeliveryFee() { return deliveryFee; }
    public BigDecimal getMinimumOrderValue() { return minimumOrderValue; }
    public BigDecimal getDiscountRate() { return discountRate; }
    public BigDecimal getTaxRate() { return taxRate; }

    @Override
    public String toString() { return displayName; }
}
