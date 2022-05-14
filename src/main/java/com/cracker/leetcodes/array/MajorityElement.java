package com.cracker.leetcodes.array;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 169: Majority Element.
 */
public class MajorityElement {

    public int majorityElement(final int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        Map.Entry<Integer, Integer> result = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (null == result || entry.getValue() > result.getValue()) {
                result = entry;
            }
        }
        assert result != null;
        return result.getKey();
    }
}
