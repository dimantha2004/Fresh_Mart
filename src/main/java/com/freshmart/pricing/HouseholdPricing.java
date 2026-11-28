package com.freshmart.pricing;

import java.math.BigDecimal;

/** Table 1 rules for Household Essentials. */
public class HouseholdPricing implements PricingStrategy {

    @Override
    public BigDecimal deliveryFee() { return new BigDecimal("500"); }

    @Override
    public BigDecimal minimumOrderValue() { return new BigDecimal("4000"); }

    @Override
    public BigDecimal discountRate() { return new BigDecimal("0.10"); }

    @Override
    public BigDecimal taxRate() { return new BigDecimal("0.10"); }
}
