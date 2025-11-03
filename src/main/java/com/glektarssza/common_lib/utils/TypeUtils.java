package com.glektarssza.common_lib.utils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A collection of type-related utilities.
 */
public class TypeUtils {
    /**
     * Check whether a value is {@code null} and cast it to a {@link Nonnull}
     * type.
     *
     * @param <T> The type of the value to check.
     * @param value The value to check.
     *
     * @return The {@code value} parameter, if non-null, cast to a
     *         {@link Nonnull} type.
     *
     * @throws NullPointerException Thrown if the {@code value} parameter is
     *         {@code null}.
     */
    @Nonnull
    public static <T> T checkNullAndCast(@Nullable T value) {
        return checkNullAndCast(value, null);
    }

    /**
     * Check whether a value is {@code null} and cast it to a {@link Nonnull}
     * type.
     *
     * @param <T> The type of the value to check.
     * @param value The value to check.
     * @param message The message to throw the {@link NullPointerException} with
     *        if the {@code value} parameter is {@code null}.
     *
     * @return The {@code value} parameter, if non-null, cast to a
     *         {@link Nonnull} type.
     *
     * @throws NullPointerException Thrown if the {@code value} parameter is
     *         {@code null}.
     */
    @Nonnull
    public static <T> T checkNullAndCast(@Nullable T value,
        @Nullable String message) {
        if (value == null) {
            throw new NullPointerException(message);
        }
        return value;
    }
}
