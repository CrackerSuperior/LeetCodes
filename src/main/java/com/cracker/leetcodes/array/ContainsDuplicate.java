package com.cracker.leetcodes.array;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 217: Contains Duplicate.
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(final int[] nums) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int num : nums) {
            if (result.containsKey(num)) {
                return true;
            }
            result.put(num, num);
        }
        return false;
    }

    /**
     * Find equal numbers while inserting sort.
     * @param nums array
     * @return result
     */
    public boolean containsDuplicatePlus(final int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            if (j > 0 && nums[j - 1] == temp) {
                return true;
            }
            nums[j] = temp;
        }
        return false;
    }
}
