package com.cracker.leetcodes.search;

/**
 * This is Leetcode number 34: Find First and Last Position of Element in Sorted Array.
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(final int[] nums, final int target) {
        return new int[]{getLeft(nums, target), getRight(nums, target)};
    }

    private int getLeft(final int[] nums, final int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid] || target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left < nums.length && target == nums[left] ? left : -1;
    }

    private int getRight(final int[] nums, final int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid] || target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right >= 0 && target == nums[right] ? right : -1;
    }
}
