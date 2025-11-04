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
        // -- https://stackoverflow.com/a/12041874/1347304
        return ((value ^ (value >> 31)) - (value >> 31));
    }

    /**
     * Get the sign of the given integer.
     *
     * @param value The integer to get the sign of.
     *
     * @return {@code -1} if the value is negative, {@code 0} if the value is
     *         {@code 0}, and {@code 1} if the value is positive.
     */
    public static int signum(int value) {
        return (0 < value ? 1 : 0) - (value < 0 ? 1 : 0);
    }
}
