package com.freshmart.pricing;

import java.math.BigDecimal;

/** Table 1 rules for Dairy. */
public class DairyPricing implements PricingStrategy {

    @Override
    public BigDecimal deliveryFee() { return new BigDecimal("400"); }

    @Override
    public BigDecimal minimumOrderValue() { return new BigDecimal("3000"); }

    @Override
    public BigDecimal discountRate() { return new BigDecimal("0.08"); }

    @Override
    public BigDecimal taxRate() { return new BigDecimal("0.08"); }
}
