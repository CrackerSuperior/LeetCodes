package com.cracker.leetcodes.array;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 525: Contiguous Array.
 */
public class ContiguousArray {

    public int findMaxLength(final int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int max = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
            if (map.containsKey(prefixSum[i])) {
                int index = i - map.get(prefixSum[i]);
                max = Math.max(max, index);
            } else {
                map.put(prefixSum[i], i);
            }
        }
        return max;
    }
}
