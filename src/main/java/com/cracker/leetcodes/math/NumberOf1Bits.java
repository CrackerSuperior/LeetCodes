package com.cracker.leetcodes.math;

/**
 * This is Leetcode number 191: Number of 1 Bits.
 */
public class NumberOf1Bits {

    public int hammingWeight(final int n) {
        int result = 0;
        int number = n;
        while (number != 0) {
            number = number & (number - 1);
            result++;
        }
        return result;
    }
}
