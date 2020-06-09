package com.scaler.naveen.splitwise.utils;

import java.math.BigDecimal;

public class Util {

    public static boolean isApproxEqual(BigDecimal value1, BigDecimal value2) {
        value1 = value1.multiply(BigDecimal.valueOf(100));
        value2 = value2.multiply(BigDecimal.valueOf(100));
        return (value1.compareTo(value2) == 0);
    }
}
