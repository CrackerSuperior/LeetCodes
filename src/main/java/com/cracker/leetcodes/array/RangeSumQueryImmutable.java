package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 303: Range Sum Query - Immutable.
 */
public class RangeSumQueryImmutable {

    static class NumArray {

        private final int[] preSum;

        NumArray(final int[] nums) {
            preSum = new int[nums.length + 1];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(final int left, final int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}

