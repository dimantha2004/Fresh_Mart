package com.freshmart.pricing;

import java.math.BigDecimal;

/** Table 1 rules for Vegetables. */
public class VegetablePricing implements PricingStrategy {

    @Override
    public BigDecimal deliveryFee() { return new BigDecimal("300"); }

    @Override
    public BigDecimal minimumOrderValue() { return new BigDecimal("2000"); }

    @Override
    public BigDecimal discountRate() { return new BigDecimal("0.05"); }

    @Override
    public BigDecimal taxRate() { return new BigDecimal("0.05"); }
}
