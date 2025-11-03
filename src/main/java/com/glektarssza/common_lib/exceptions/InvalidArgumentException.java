package com.glektarssza.common_lib.exceptions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * An exception type indicating an argument as invalid.
 */
public class InvalidArgumentException extends RuntimeException {
    /**
     * The name of the argument that was invalid.
     */
    @Nonnull
    public final String argumentName;

    /**
     * Create a new instance with the given argument name.
     *
     * @param argumentName The name of the argument that was invalid.
     */
    public InvalidArgumentException(@Nonnull String argumentName) {
        this(argumentName, null);
    }

    /**
     * Create a new instance with the given argument name and message.
     *
     * @param argumentName The name of the argument that was invalid.
     * @param message A message describing the nature of the exception.
     */
    public InvalidArgumentException(@Nonnull String argumentName,
        @Nullable String message) {
        this(argumentName, message, null);
    }

    /**
     * Create a new instance with the given argument name and message.
     *
     * @param argumentName The name of the argument that was invalid.
     * @param message A message describing the nature of the exception.
     * @param cause The exception that triggered the newly created exception.
     */
    public InvalidArgumentException(@Nonnull String argumentName,
        @Nullable String message, @Nullable Throwable cause) {
        super(message, cause);
        this.argumentName = argumentName;
    }
}
