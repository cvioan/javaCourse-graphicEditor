package com.cioan.graphicEditor.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {
    Utils() {}

    public static double roundDoubleTwoDecimals(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
