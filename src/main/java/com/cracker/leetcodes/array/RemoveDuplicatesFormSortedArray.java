package com.cracker.leetcodes.array;

import java.util.Arrays;

/**
 * This is Leetcode number 26: Remove Duplicates from Sorted Array.
 */
public class RemoveDuplicatesFormSortedArray {

    public int removeDuplicates(final int[] nums) {
        int[] results = Arrays.stream(nums).distinct().toArray();
        System.arraycopy(results, 0, nums, 0, results.length);
        return results.length;
    }

    public int removeDuplicatesPlus(final int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < len) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
