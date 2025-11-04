package com.glektarssza.common_lib.utils;

public class IntMathUtils {
    /**
     * Get the absolute (without the sign) value of the given integer.
     *
     * @param value The integer to get the absolute value of.
     *
     * @return The absolute value of the integer.
     *
     * @see #absolute
     */
    public static int abs(int value) {
        return absolute(value);
    }

    /**
     * Get the absolute (without the sign) value of the given integer.
     *
     * @param value The integer to get the absolute value of.
     *
     * @return The absolute value of the integer.
     */
    public static int absolute(int value) {
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

    /**
     * Copy the sign from a given number to another number.
     *
     * @param magnitude The number to copy the sign of the other number on to.
     * @param sign The number to copy the sign of.
     *
     * @return The value of the {@code magnitude} parameter with sign of the
     *         {@code sign} parameter.
     */
    public static int copySign(int magnitude, int sign) {
        return (signum(sign) < 0 ? -1 : 1) * absolute(magnitude);
    }
}
