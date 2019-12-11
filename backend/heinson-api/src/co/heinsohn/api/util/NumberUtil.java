package co.heinsohn.api.util;

import java.math.BigDecimal;

public class NumberUtil {

    public static Double StrintToDouble(String value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.doubleValue();
    }

}
