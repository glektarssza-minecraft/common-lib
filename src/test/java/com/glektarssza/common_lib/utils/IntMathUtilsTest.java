package com.glektarssza.common_lib.utils;

import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.datafaker.Faker;

public class IntMathUtilsTest {
    public static final Faker fakerInstance = new Faker(Locale.ENGLISH);

    @Test
    public void testAbs() {
        // -- Given
        int value = fakerInstance.number().negative();

        // -- When
        int result = IntMathUtils.abs(value);

        // -- Then
        Assertions.assertTrue(result == (int) Math.abs(value));

        // -- Given
        value = fakerInstance.number().positive();

        // -- When
        result = IntMathUtils.abs(value);

        // -- Then
        Assertions.assertTrue(result == (int) Math.abs(value));

        // -- Given
        value = 0;

        // -- When
        result = IntMathUtils.abs(value);

        // -- Then
        Assertions.assertTrue(result == (int) Math.abs(value));
    }
}
