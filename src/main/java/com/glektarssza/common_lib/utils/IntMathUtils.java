package com.glektarssza.common_lib.utils;

public class IntMathUtils {
    /**
     * Get the absolute (without the sign) value of the given integer.
     *
     * @param value The integer to get the absolute value of.
     *
     * @return The absolute value of the integer.
     */
    public static int abs(int value) {
        return Integer.signum(value) < 0 ? 0 - value : value;
    }
}
