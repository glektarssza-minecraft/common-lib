package com.glektarssza.common_lib.utils;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import net.datafaker.Faker;

/**
 * Tests for the {@link IntMathUtils} class.
 */
public class IntMathUtilsTest {
    /**
     * The fake data instance.
     */
    public static final Faker fakerInstance = new Faker(Locale.ENGLISH);

    @Test
    @DisplayName("Test that `absolute` returns a positive number when given a negative value")
    public void testAbsNegative() {
        // -- Given
        int value = fakerInstance.number().negative();

        // -- When
        int result = IntMathUtils.absolute(value);

        // -- Then
        Assertions.assertThat(result).isPositive();
        Assertions.assertThat(result).isEqualTo((int) Math.abs(value));
    }

    @Test
    @DisplayName("Test that `absolute` returns the same number when given a positive value")
    public void testAbsPositive() {
        // -- Given
        int value = fakerInstance.number().positive();

        // -- When
        int result = IntMathUtils.absolute(value);

        // -- Then
        Assertions.assertThat(result).isPositive();
        Assertions.assertThat(result).isEqualTo(value);
    }

    @Test
    @DisplayName("Test that `absolute` returns zero when given a zero value")
    public void testAbsZero() {
        // -- Given
        int value = 0;

        // -- When
        int result = IntMathUtils.absolute(value);

        // -- Then
        Assertions.assertThat(result).isEqualTo(value);
    }

    @Test
    @DisplayName("Test that `signum` returns negative one when given a negative value")
    public void testSignumNegative() {
        // -- Given
        int value = fakerInstance.number().negative();

        // -- When
        int result = IntMathUtils.signum(value);

        // -- Then
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("Test that `signum` returns positive one when given a positive value")
    public void testSignumPositive() {
        // -- Given
        int value = fakerInstance.number().positive();

        // -- When
        int result = IntMathUtils.signum(value);

        // -- Then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("Test that `signum` returns zero when given a zero value")
    public void testSignumZero() {
        // -- Given
        int value = 0;

        // -- When
        int result = IntMathUtils.signum(value);

        // -- Then
        Assertions.assertThat(result).isEqualTo(value);
    }

    @Test
    @DisplayName("Test that `copySign` returns a negative when given a positive magnitude and a negative sign")
    public void testCopySignPositiveMagnitudeAndNegativeSign() {
        // -- Given
        int magnitude = fakerInstance.number().positive();
        int sign = fakerInstance.number().negative();

        // -- When
        int result = IntMathUtils.copySign(magnitude, sign);

        // -- Then
        Assertions.assertThat(result)
            .isEqualTo(-magnitude);
    }

    @Test
    @DisplayName("Test that `copySign` returns a positive when given a positive magnitude and a positive sign")
    public void testCopySignPositiveMagnitudeAndPositiveSign() {
        // -- Given
        int magnitude = fakerInstance.number().positive();
        int sign = fakerInstance.number().positive();

        // -- When
        int result = IntMathUtils.copySign(magnitude, sign);

        // -- Then
        Assertions.assertThat(result)
            .isEqualTo(magnitude);
    }

    @Test
    @DisplayName("Test that `copySign` returns a positive when given a negative magnitude and a positive sign")
    public void testCopySignNegativeMagnitudeAndPositiveSign() {
        // -- Given
        int magnitude = fakerInstance.number().negative();
        int sign = fakerInstance.number().positive();

        // -- When
        int result = IntMathUtils.copySign(magnitude, sign);

        // -- Then
        Assertions.assertThat(result)
            .isEqualTo(-magnitude);
    }

    @Test
    @DisplayName("Test that `copySign` returns a negative when given a negative magnitude and a negative sign")
    public void testCopySignNegativeMagnitudeAndNegativeSign() {
        // -- Given
        int magnitude = fakerInstance.number().negative();
        int sign = fakerInstance.number().negative();

        // -- When
        int result = IntMathUtils.copySign(magnitude, sign);

        // -- Then
        Assertions.assertThat(result)
            .isEqualTo(magnitude);
    }

    @Test
    @DisplayName("Test that `copySign` returns zero when given a zero magnitude and a positive sign")
    public void testCopySignZeroMagnitudeAndPositiveSign() {
        // -- Given
        int magnitude = 0;
        int sign = fakerInstance.number().positive();

        // -- When
        int result = IntMathUtils.copySign(magnitude, sign);

        // -- Then
        Assertions.assertThat(result)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Test that `copySign` returns zero when given a zero magnitude and a negative sign")
    public void testCopySignZeroMagnitudeAndNegativeSign() {
        // -- Given
        int magnitude = 0;
        int sign = fakerInstance.number().negative();

        // -- When
        int result = IntMathUtils.copySign(magnitude, sign);

        // -- Then
        Assertions.assertThat(result)
            .isEqualTo(0);
    }
}
