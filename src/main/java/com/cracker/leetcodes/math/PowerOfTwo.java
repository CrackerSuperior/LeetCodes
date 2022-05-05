package com.cracker.leetcodes.math;

/**
 * This is Leetcode number 231: Power of Two.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(final int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
