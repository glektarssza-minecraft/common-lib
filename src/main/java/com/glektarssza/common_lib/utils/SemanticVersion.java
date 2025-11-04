package com.glektarssza.common_lib.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Chars;

import com.glektarssza.common_lib.exceptions.InvalidArgumentException;

public class SemanticVersion implements Comparable<SemanticVersion> {
    private static final Character[] VALID_ASCII = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c',
        'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
        'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E',
        'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
        'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private static final Character[] VALID_DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
    };

    /**
     * The major version number.
     */
    private int major;

    /**
     * The minor version number.
     */
    private int minor;

    /**
     * The revision version number.
     */
    private int revision;

    /**
     * The pre-release version identifiers.
     */
    private List<String> preRelease;

    /**
     * The build metadata identifiers..
     */
    private List<String> buildMetadata;

    /**
     * Create a new instance with all version numbers set to {@code 0} and no
     * pre-release version or build metadata.
     */
    public SemanticVersion() {
        this(0, 0, 0);
    }

    /**
     * Create a new instance with the given major version, all other version
     * numbers set to {@code 0}, and no pre-release version or build metadata.
     *
     * @param major The major version number to create the new instance with.
     */
    public SemanticVersion(int major) {
        this(major, 0, 0);
    }

    /**
     * Create a new instance with the given major and minor version, all other
     * version numbers set to {@code 0}, and no pre-release version or build
     * metadata.
     *
     * @param major The major version number to create the new instance with.
     * @param minor The minor version number to create the new instance with.
     */
    public SemanticVersion(int major, int minor) {
        this(major, minor, 0);
    }

    /**
     * Create a new instance with the given major, minor and revision versions
     * and no pre-release version or build metadata.
     *
     * @param major The major version number to create the new instance with.
     * @param minor The minor version number to create the new instance with.
     * @param revision The revision version number to create the new instance
     *        with.
     */
    public SemanticVersion(int major, int minor, int revision) {
        this(major, minor, revision, Collections.emptyList());
    }

    /**
     * Create a new instance with the given major, minor and revision versions.
     *
     * @param major The major version number to create the new instance with.
     * @param minor The minor version number to create the new instance with.
     * @param revision The revision version number to create the new instance
     *        with.
     * @param preRelease The pre-release versions to create the new instance
     *        with.
     */
    public SemanticVersion(int major, int minor, int revision,
        Iterable<String> preRelease) {
        this(major, minor, revision, preRelease, Collections.emptyList());
    }

    /**
     * Create a new instance with the given major, minor and revision versions.
     *
     * @param major The major version number to create the new instance with.
     * @param minor The minor version number to create the new instance with.
     * @param revision The revision version number to create the new instance
     *        with.
     * @param preRelease The pre-release versions to create the new instance
     *        with.
     * @param buildMetadata The build metadata to create the new instance with.
     */
    public SemanticVersion(int major, int minor, int revision,
        Iterable<String> preRelease, Iterable<String> buildMetadata) {
        if (major < 0) {
            throw new InvalidArgumentException("major",
                "Major version number is less than zero");
        }
        if (minor < 0) {
            throw new InvalidArgumentException("minor",
                "Minor version number is less than zero");
        }
        if (revision < 0) {
            throw new InvalidArgumentException("revision",
                "Revision version number is less than zero");
        }
        this.major = major;
        this.minor = minor;
        this.revision = revision;
        this.preRelease = new ArrayList<String>();
        preRelease.forEach((preReleaseId) -> {
            if (preReleaseId.isEmpty()) {
                throw new InvalidArgumentException("preRelease",
                    "Pre-release identifier list contains an empty identifier string");
            }
            if (!Arrays.stream(VALID_ASCII).anyMatch((toCheck) -> {
                return Chars.contains(
                    TypeUtils.checkNullAndCast(preReleaseId.toCharArray()),
                    toCheck);
            })) {
                throw new InvalidArgumentException("preRelease",
                    String.format(
                        "Pre-release identifier list item \"%s\" contains non-valid semantic version characters",
                        preReleaseId));
            }
            if (Arrays.stream(VALID_DIGITS).allMatch((toCheck) -> {
                return Chars.contains(
                    TypeUtils.checkNullAndCast(preReleaseId.toCharArray()),
                    toCheck);
            }) && preReleaseId.startsWith("0")) {
                throw new InvalidArgumentException("preRelease",
                    String.format(
                        "Pre-release identifier \"%s\" is numerical only and starts with a zero",
                        preReleaseId));
            }
            this.preRelease.add(preReleaseId);
        });
        this.buildMetadata = new ArrayList<String>();
        buildMetadata.forEach((buildMetadataId) -> {
            if (buildMetadataId.isEmpty()) {
                throw new InvalidArgumentException("buildMetadata",
                    "Build metadata identifier list contains an empty identifier string");
            }
            if (!Arrays.stream(VALID_ASCII).anyMatch((toCheck) -> {
                return Chars.contains(
                    TypeUtils.checkNullAndCast(buildMetadataId.toCharArray()),
                    toCheck);
            })) {
                throw new InvalidArgumentException("buildMetadata",
                    String.format(
                        "Build metadata identifier list item \"%s\" contains non-valid semantic version characters",
                        buildMetadataId));
            }
            this.buildMetadata.add(buildMetadataId);
        });
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public int getRevision() {
        return this.revision;
    }

    @Nonnull
    public ImmutableList<String> getPreRelease() {
        return TypeUtils
            .checkNullAndCast(ImmutableList.copyOf(this.preRelease));
    }

    @Nonnull
    public ImmutableList<String> getBuildMetadata() {
        return TypeUtils
            .checkNullAndCast(ImmutableList.copyOf(this.buildMetadata));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.major ^ (this.major >>> 32));
        result = prime * result + (int) (this.minor ^ (this.minor >>> 32));
        result = prime * result
            + (int) (this.revision ^ (this.revision >>> 32));
        result = prime * result + (int) (this.preRelease.hashCode()
            ^ (this.preRelease.hashCode() >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SemanticVersion version) {
            return this.compareTo(version) == 0;
        }
        return false;
    }

    @Override
    public int compareTo(SemanticVersion other) {
        if (other == null) {
            return 1;
        }
        if (this.major != other.major) {
            return IntMathUtils.copySign(1, this.major - other.major);
        }
        if (this.minor != other.minor) {
            return IntMathUtils.copySign(1, this.minor - other.minor);
        }
        if (this.revision != other.revision) {
            return IntMathUtils.copySign(1, this.revision - other.revision);
        }
        // TODO: Compare pre-release identifiers
        return 0;
    }
}
