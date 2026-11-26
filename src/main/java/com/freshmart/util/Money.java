package com.freshmart.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/** Currency helpers. All amounts are LKR and kept to 2 decimal places. */
public final class Money {
    private Money() { }

    public static BigDecimal round(BigDecimal amount) {
        return amount.setScale(2, RoundingMode.HALF_UP);
    }

    public static String format(BigDecimal amount) {
        return "LKR " + new DecimalFormat("#,##0.00").format(amount);
    }

    public static String percent(BigDecimal rate) {
        return rate.movePointRight(2).stripTrailingZeros().toPlainString() + "%";
    }
}
