package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 136: Single Number.
 */
public class SingleNumber {

    public int singleNumber(final int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
