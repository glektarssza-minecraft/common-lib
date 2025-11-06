package com.glektarssza.common_lib.utils;

/**
 * A simple version number implementation.
 *
 * A version number follows the "standard" three number implementation of
 * {@code major.minor.revision}.
 *
 * Instances of this class are immutable.
 */
public class Version implements Comparable<Version> {
    /**
     * The major version number.
     */
    public final int major;

    /**
     * The minor version number.
     */
    public final int minor;

    /**
     * The revision version number.
     */
    public final int revision;

    /**
     * Create a new instance.
     */
    public Version() {
        this.major = 0;
        this.minor = 0;
        this.revision = 0;
    }

    /**
     * Create a new instance with the given data.
     *
     * @param major The major version number.
     */
    public Version(int major) {
        this.major = major;
        this.minor = 0;
        this.revision = 0;
    }

    /**
     * Create a new instance with the given data.
     *
     * @param major The major version number.
     * @param minor The minor version number.
     */
    public Version(int major, int minor) {
        this.major = major;
        this.minor = minor;
        this.revision = 0;
    }

    /**
     * Create a new instance with the given data.
     *
     * @param major The major version number.
     * @param minor The minor version number.
     * @param revision The revision version number.
     */
    public Version(int major, int minor, int revision) {
        this.major = major;
        this.minor = minor;
        this.revision = revision;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Version(this.major, this.minor, this.revision);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + this.major;
        result = prime * result + this.minor;
        result = prime * result + this.revision;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Version other) {
            return this.major == other.major &&
                this.minor == other.minor &&
                this.revision == other.revision;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Version o) {
        if (this.major != o.major) {
            return IntMathUtils.copySign(1, this.major - o.major);
        }
        if (this.minor != o.minor) {
            return IntMathUtils.copySign(1, this.minor - o.minor);
        }
        if (this.revision != o.revision) {
            return IntMathUtils.copySign(1, this.revision - o.revision);
        }
        return 0;
    }
}
