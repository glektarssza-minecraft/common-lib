package com.glektarssza.common_lib.utils.function;

/**
 * A function that accepts three arguments and produces a result.
 *
 * @param <T1> The type of the first argument.
 * @param <T2> The type of the second argument.
 * @param <T3> The type of the third argument.
 * @param <R> The type of the result.
 */
public interface TernaryFunction<T1, T2, T3, R> {
    /**
     * Invoke the function.
     *
     * @param arg1 The first function argument.
     * @param arg2 The second function argument.
     * @param arg3 The third function argument.
     *
     * @return The function result.
     */
    R invoke(T1 arg1, T2 arg2, T3 arg3);
}
