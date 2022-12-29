package com.cracker.leetcodes.math;

/**
 * This is Leetcode number 367: Efficient Perfect Squares.
 */
public class EfficientPerfectSquares {

    public boolean isPerfectSquare(final int num) {
        long x = num;
        while (x * x > num) {
            x = (num / x + x) / 2;
        }
        return x * x == num;
    }
}
