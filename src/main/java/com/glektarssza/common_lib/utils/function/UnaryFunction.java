package com.glektarssza.common_lib.utils.function;

/**
 * A function that accepts one argument and produces a result.
 *
 * @param <T> The type of the argument.
 * @param <R> The type of the result.
 */
public interface UnaryFunction<T, R> {
    /**
     * Invoke the function.
     *
     * @param arg The function argument.
     *
     * @return The function result.
     */
    R invoke(T arg);
}
