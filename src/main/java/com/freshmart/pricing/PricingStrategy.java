package com.freshmart.pricing;

import com.freshmart.util.Money;

import java.math.BigDecimal;

/**
 * STRATEGY pattern: the pricing rules of one product category. Implementations are
 * interchangeable, so billing code works with this interface and never names a category.
 */
public interface PricingStrategy {

    BigDecimal deliveryFee();

    BigDecimal minimumOrderValue();

    BigDecimal discountRate();

    BigDecimal taxRate();

    /** A strategy may override this to use a different discount rule, such as tiers. */
    default BigDecimal discountOn(BigDecimal categorySubtotal) {
        return Money.round(categorySubtotal.multiply(discountRate()));
    }

    default BigDecimal taxOn(BigDecimal taxableAmount) {
        return Money.round(taxableAmount.multiply(taxRate()));
    }
}
