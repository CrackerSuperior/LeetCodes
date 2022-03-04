package com.cracker.leetcodes.map;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 1: Two Sum.
 */
public class TwoSum {

    public int[] twoSum(final int[] nums, final int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
