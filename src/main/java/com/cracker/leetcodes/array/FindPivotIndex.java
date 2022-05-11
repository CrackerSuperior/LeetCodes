package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 724: Find Pivot Index.
 */
public class FindPivotIndex {

    public int pivotIndex(final int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] - nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum[i] == prefixSum[nums.length] - prefixSum[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
