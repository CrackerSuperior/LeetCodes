package com.cracker.leetcodes.math;

/**
 * This is Leetcode number 509: Fibonacci Number.
 */
public class FibonacciNumber {

    public int fib(final int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
