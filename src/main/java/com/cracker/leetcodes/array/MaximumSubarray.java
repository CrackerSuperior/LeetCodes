package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 53: Maximum Subarray.
 */
public class MaximumSubarray {

    public int maxSubArray(final int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public int maxSubArrayPlus(final int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
