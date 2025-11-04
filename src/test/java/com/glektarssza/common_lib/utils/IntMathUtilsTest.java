package com.glektarssza.common_lib.utils;

import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import net.datafaker.Faker;

public class IntMathUtilsTest {
    public static final Faker fakerInstance = new Faker(Locale.ENGLISH);

    @Test
    @DisplayName("Test that `abs` returns a positive number when given a negative value")
    public void testAbsNegative() {
        // -- Given
        int value = fakerInstance.number().negative();

        // -- When
        int result = IntMathUtils.abs(value);

        // -- Then
        Assertions.assertTrue(result == (int) Math.abs(value));
    }

    @Test
    @DisplayName("Test that `abs` returns the same number when given a positive value")
    public void testAbsPositive() {
        // -- Given
        int value = fakerInstance.number().positive();

        // -- When
        int result = IntMathUtils.abs(value);

        // -- Then
        Assertions.assertEquals(value, result);
    }

    @Test
    @DisplayName("Test that `abs` returns zero when given a zero value")
    public void testAbsZero() {
        // -- Given
        int value = 0;

        // -- When
        int result = IntMathUtils.abs(value);

        // -- Then
        Assertions.assertEquals(value, result);
    }

    @Test
    @DisplayName("Test that `signum` returns negative one when given a negative value")
    public void testSignumNegative() {
        // -- Given
        int value = fakerInstance.number().negative();

        // -- When
        int result = IntMathUtils.signum(value);

        // -- Then
        Assertions.assertEquals(-1, result);
    }

    @Test
    @DisplayName("Test that `signum` returns positive one when given a positive value")
    public void testSignumPositive() {
        // -- Given
        int value = fakerInstance.number().positive();

        // -- When
        int result = IntMathUtils.signum(value);

        // -- Then
        Assertions.assertEquals(result, 1);
    }

    @Test
    @DisplayName("Test that `signum` returns zero when given a zero value")
    public void testSignumZero() {
        // -- Given
        int value = 0;

        // -- When
        int result = IntMathUtils.signum(value);

        // -- Then
        Assertions.assertEquals(result, 0);
    }
}
