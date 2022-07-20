package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 215: Kth Largest Element in an Array.
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(final int[] nums, final int k) {
        int kth = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = partition(nums, left, right);
            if (mid > kth) {
                right = mid - 1;
            } else if (mid < kth) {
                left = mid + 1;
            } else {
                return nums[mid];
            }
        }
        return -1;
    }

    private int partition(final int[] nums, final int left, final int right) {
        int pivot = nums[left];
        int leftIndex = left + 1;
        int rightIndex = right;
        while (true) {
            while (leftIndex < right && nums[leftIndex] <= pivot) {
                leftIndex++;
            }
            while (rightIndex > left && nums[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex >= rightIndex) {
                break;
            }
            swap(nums, leftIndex, rightIndex);
        }
        swap(nums, left, rightIndex);
        return rightIndex;
    }

    private void swap(final int[] nums, final int left, final int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
