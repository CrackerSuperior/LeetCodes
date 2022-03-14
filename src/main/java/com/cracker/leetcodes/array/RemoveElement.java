package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 27: Remove Element.
 */
public class RemoveElement {

    public int removeElement(final int[] nums, final int val) {
        int[] temp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            if (num != val) {
                temp[len++] = num;
            }
        }
        System.arraycopy(temp, 0, nums, 0, temp.length);
        return len;
    }

    public int removeElementPlus(final int[] nums, final int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
