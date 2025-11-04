package com.glektarssza.common_lib.utils;

import java.util.List;
import java.util.Locale;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import net.datafaker.Faker;

/**
 * Tests for the {@link SemanticVersion} class.
 */
public class SemanticVersionTest {
    /**
     * The fake data instance.
     */
    public static final Faker fakerInstance = new Faker(Locale.ENGLISH);

    @Test
    @DisplayName("Test that the blank constructor returns an empty semantic version")
    public void testBlankCtor() {
        // -- Given

        // -- When
        SemanticVersion result = new SemanticVersion();

        // -- Then
        Assertions.assertThat(result.getMajor()).isZero();
        Assertions.assertThat(result.getMinor()).isZero();
        Assertions.assertThat(result.getRevision()).isZero();
        Assertions.assertThat(result.getPreRelease()).isEmpty();
        Assertions.assertThat(result.getBuildMetadata()).isEmpty();
    }

    @Test
    @DisplayName("Test that the major version constructor returns a semantic version with the given data")
    public void testMajorCtor() {
        // -- Given
        int major = fakerInstance.number().positive();

        // -- When
        SemanticVersion result = new SemanticVersion(major);

        // -- Then
        Assertions.assertThat(result.getMajor()).isEqualTo(major);
        Assertions.assertThat(result.getMinor()).isZero();
        Assertions.assertThat(result.getRevision()).isZero();
        Assertions.assertThat(result.getPreRelease()).isEmpty();
        Assertions.assertThat(result.getBuildMetadata()).isEmpty();
    }

    @Test
    @DisplayName("Test that the major/minor version constructor returns a semantic version with the given data")
    public void testMajorMinorCtor() {
        // -- Given
        int major = fakerInstance.number().positive();
        int minor = fakerInstance.number().positive();

        // -- When
        SemanticVersion result = new SemanticVersion(major, minor);

        // -- Then
        Assertions.assertThat(result.getMajor()).isEqualTo(major);
        Assertions.assertThat(result.getMinor()).isEqualTo(minor);
        Assertions.assertThat(result.getRevision()).isZero();
        Assertions.assertThat(result.getPreRelease()).isEmpty();
        Assertions.assertThat(result.getBuildMetadata()).isEmpty();
    }

    @Test
    @DisplayName("Test that the major/minor/revision version constructor returns a semantic version with the given data")
    public void testMajorMinorRevCtor() {
        // -- Given
        int major = fakerInstance.number().positive();
        int minor = fakerInstance.number().positive();
        int revision = fakerInstance.number().positive();

        // -- When
        SemanticVersion result = new SemanticVersion(major, minor, revision);

        // -- Then
        Assertions.assertThat(result.getMajor()).isEqualTo(major);
        Assertions.assertThat(result.getMinor()).isEqualTo(minor);
        Assertions.assertThat(result.getRevision()).isEqualTo(revision);
        Assertions.assertThat(result.getPreRelease()).isEmpty();
        Assertions.assertThat(result.getBuildMetadata()).isEmpty();
    }

    @Test
    @DisplayName("Test that the major/minor/revision/pre-release constructor returns a semantic version with the given data")
    public void testMajorMinorRevPreReleaseCtor() {
        // -- Given
        int major = fakerInstance.number().positive();
        int minor = fakerInstance.number().positive();
        int revision = fakerInstance.number().positive();
        List<String> preRelease = fakerInstance.collection().minLen(3)
            .maxLen(10).nullRate(0)
            .suppliers(
                () -> fakerInstance.text().text(1, 1, false, false, true),
                () -> fakerInstance.hashing().sha1().substring(0, 5),
                () -> fakerInstance.app().version())
            .generate();

        // -- When
        SemanticVersion result = new SemanticVersion(major, minor, revision,
            preRelease);

        // -- Then
        Assertions.assertThat(result.getMajor()).isEqualTo(major);
        Assertions.assertThat(result.getMinor()).isEqualTo(minor);
        Assertions.assertThat(result.getRevision()).isEqualTo(revision);
        Assertions.assertThat(result.getPreRelease()).isNotEmpty();
        Assertions.assertThat(result.getPreRelease()).containsAll(preRelease);
        Assertions.assertThat(result.getBuildMetadata()).isEmpty();
    }

    @Test
    @DisplayName("Test that the major/minor/revision/pre-release/build metadata constructor returns a semantic version with the given data")
    public void testMajorMinorRevPreReleaseBuildCtor() {
        // -- Given
        int major = fakerInstance.number().positive();
        int minor = fakerInstance.number().positive();
        int revision = fakerInstance.number().positive();
        List<String> preRelease = fakerInstance.collection().minLen(3)
            .maxLen(10).nullRate(0)
            .suppliers(
                () -> fakerInstance.text().text(1, 1, false, false, true),
                () -> fakerInstance.hashing().sha1().substring(0, 5),
                () -> fakerInstance.app().version())
            .generate();
        List<String> buildMetadata = fakerInstance.collection().minLen(3)
            .maxLen(10).nullRate(0).suppliers(
                () -> fakerInstance.text().text(1, 1, false, false, true),
                () -> fakerInstance.hashing().sha1().substring(0, 5),
                () -> fakerInstance.app().version())
            .generate();

        // -- When
        SemanticVersion result = new SemanticVersion(major, minor, revision,
            preRelease, buildMetadata);

        // -- Then
        Assertions.assertThat(result.getMajor()).isEqualTo(major);
        Assertions.assertThat(result.getMinor()).isEqualTo(minor);
        Assertions.assertThat(result.getRevision()).isEqualTo(revision);
        Assertions.assertThat(result.getPreRelease()).isNotEmpty();
        Assertions.assertThat(result.getPreRelease()).containsAll(preRelease);
        Assertions.assertThat(result.getBuildMetadata()).isNotEmpty();
        Assertions.assertThat(result.getBuildMetadata())
            .containsAll(buildMetadata);
    }

    @Test
    @DisplayName("Test that the major/minor/revision/pre-release constructor fails when given invalid pre-release data")
    public void testMajorMinorRevPreReleaseCtorFailsWithInvalid() {
        // -- Given
        int major = fakerInstance.number().positive();
        int minor = fakerInstance.number().positive();
        int revision = fakerInstance.number().positive();
        List<String> preRelease = fakerInstance.collection().minLen(3)
            .maxLen(10).nullRate(0)
            .suppliers(
                () -> fakerInstance.text().text(1, 1, false, false, true),
                () -> fakerInstance.hashing().sha1().substring(0, 5),
                () -> fakerInstance.app().version())
            .generate();

        // -- When
        SemanticVersion result = new SemanticVersion(major, minor, revision,
            preRelease);

        // -- Then
        Assertions.assertThat(result.getMajor()).isEqualTo(major);
        Assertions.assertThat(result.getMinor()).isEqualTo(minor);
        Assertions.assertThat(result.getRevision()).isEqualTo(revision);
        Assertions.assertThat(result.getPreRelease()).isNotEmpty();
        Assertions.assertThat(result.getPreRelease()).containsAll(preRelease);
        Assertions.assertThat(result.getBuildMetadata()).isEmpty();
    }

    @Test
    @DisplayName("Test that the major/minor/revision/pre-release/build metadata constructor fails when given invalid pre-release data")
    public void testMajorMinorRevPreReleaseBuildCtorFailsWithInvalid() {
        // -- Given
        int major = fakerInstance.number().positive();
        int minor = fakerInstance.number().positive();
        int revision = fakerInstance.number().positive();
        List<String> preRelease = fakerInstance.collection().minLen(3)
            .maxLen(10).nullRate(0)
            .suppliers(
                () -> fakerInstance.text().text(1, 1, false, false, true),
                () -> fakerInstance.hashing().sha1().substring(0, 5),
                () -> fakerInstance.app().version())
            .generate();
        List<String> buildMetadata = fakerInstance.collection().minLen(3)
            .maxLen(10).nullRate(0).suppliers(
                () -> fakerInstance.text().text(1, 1, false, false, true),
                () -> fakerInstance.hashing().sha1().substring(0, 5),
                () -> fakerInstance.app().version())
            .generate();

        // -- When
        SemanticVersion result = new SemanticVersion(major, minor, revision,
            preRelease, buildMetadata);

        // -- Then
        Assertions.assertThat(result.getMajor()).isEqualTo(major);
        Assertions.assertThat(result.getMinor()).isEqualTo(minor);
        Assertions.assertThat(result.getRevision()).isEqualTo(revision);
        Assertions.assertThat(result.getPreRelease()).isNotEmpty();
        Assertions.assertThat(result.getPreRelease()).containsAll(preRelease);
        Assertions.assertThat(result.getBuildMetadata()).isNotEmpty();
        Assertions.assertThat(result.getBuildMetadata())
            .containsAll(buildMetadata);
    }
}
