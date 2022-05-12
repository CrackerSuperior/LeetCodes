package com.cracker.leetcodes.array;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 523: Continuous Subarray Sum.
 */
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(final int[] nums, final int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            int key = prefixSum[i] % k;
            if (!map.containsKey(key)) {
                map.put(key, i);
            } else {
                if (i - map.get(key) >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
