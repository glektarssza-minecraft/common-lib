package com.glektarssza.common_lib.utils.function;

/**
 * A function that accepts two arguments and produces no result.
 *
 * @param <T1> The type of the first argument.
 * @param <T2> The type of the second argument.
 */
public interface BinaryConsumer<T1, T2> {
    /**
     * Invoke the function.
     *
     * @param arg1 The first function argument.
     * @param arg2 The second function argument.
     */
    void invoke(T1 arg1, T2 arg2);
}
