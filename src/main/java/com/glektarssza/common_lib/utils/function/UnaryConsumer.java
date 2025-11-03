package com.glektarssza.common_lib.utils.function;

/**
 * A function that accepts one argument and produces a result.
 *
 * @param <T> The type of the argument.
 */
public interface UnaryConsumer<T> {
    /**
     * Invoke the function.
     *
     * @param arg The function argument.
     */
    void invoke(T arg);
}
