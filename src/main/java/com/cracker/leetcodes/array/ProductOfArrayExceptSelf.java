package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 238: Product of Array Except Self.
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(final int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];
        prefix[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        suffix[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        int[] result = new int[length];
        result[0] = suffix[1];
        result[length - 1] = prefix[length - 2];
        for (int i = 1; i < length - 1; i++) {
            result[i] = prefix[i - 1] * suffix[i + 1];
        }
        return result;
    }
}
