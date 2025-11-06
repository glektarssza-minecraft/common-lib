package com.glektarssza.common_lib.utils;

import java.util.Locale;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import net.datafaker.Faker;

/**
 * Tests for the {@link Version} class.
 */
public class VersionTests {
    /**
     * The fake data instance.
     */
    public static final Faker fakerInstance = new Faker(Locale.ENGLISH);

    @Test
    @DisplayName("Test that the blank constructor creates an empty instance.")
    public void testBlankCtor() {
        // -- Given

        // -- When
        Version result = new Version();

        // -- Then
        Assertions.assertThat(result.major).isZero();
        Assertions.assertThat(result.minor).isZero();
        Assertions.assertThat(result.revision).isZero();
    }

    @Test
    @DisplayName("Test that the major version number constructor creates an instance with the given data.")
    public void testMajorCtor() {
        // -- Given
        int major = fakerInstance.number().positive();

        // -- When
        Version result = new Version(major);

        // -- Then
        Assertions.assertThat(result.major).isEqualTo(major);
        Assertions.assertThat(result.minor).isZero();
        Assertions.assertThat(result.revision).isZero();
    }

    @Test
    @DisplayName("Test that the major/minor version number constructor creates an instance with the given data.")
    public void testMajorMinorCtor() {
        // -- Given
        int major = fakerInstance.number().positive();
        int minor = fakerInstance.number().positive();

        // -- When
        Version result = new Version(major, minor);

        // -- Then
        Assertions.assertThat(result.major).isEqualTo(major);
        Assertions.assertThat(result.minor).isEqualTo(minor);
        Assertions.assertThat(result.revision).isZero();
    }

    @Test
    @DisplayName("Test that the major/minor/revision version number constructor creates an instance with the given data.")
    public void testMajorMinorRevisionCtor() {
        // -- Given
        int major = fakerInstance.number().positive();
        int minor = fakerInstance.number().positive();
        int revision = fakerInstance.number().positive();

        // -- When
        Version result = new Version(major, minor, revision);

        // -- Then
        Assertions.assertThat(result.major).isEqualTo(major);
        Assertions.assertThat(result.minor).isEqualTo(minor);
        Assertions.assertThat(result.revision).isEqualTo(revision);
    }

    @Test
    @DisplayName("Test that two versions with differing revisions return proper comparisons.")
    public void testCompareRevisions() {
        // -- Given
        int major = fakerInstance.number().positive();
        int minor = fakerInstance.number().positive();
        int revisionHigh = fakerInstance.number().positive();
        int revisionLow = fakerInstance.number().numberBetween(1, revisionHigh);
        Version versionHigh = new Version(major, minor, revisionHigh);
        Version versionLow = new Version(major, minor, revisionLow);

        // -- When
        int resultHighToLow = versionHigh.compareTo(versionLow);
        int resultLowToHigh = versionLow.compareTo(versionHigh);
        int resultHighToHigh = versionHigh.compareTo(versionHigh);

        // -- Then
        Assertions.assertThat(resultHighToHigh).isZero();
        Assertions.assertThat(resultHighToLow).isEqualTo(1);
        Assertions.assertThat(resultLowToHigh).isEqualTo(-1);
    }
}
