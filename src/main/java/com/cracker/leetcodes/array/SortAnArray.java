package com.cracker.leetcodes.array;

import java.util.Random;

/**
 * This is Leetcode number 912: Sort an Array.
 */
public class SortAnArray {

    public int[] sortArray(final int[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void shuffle(final int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private void sort(final int[] nums, final int leftIndex, final int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int mid = partition(nums, leftIndex, rightIndex);
        sort(nums, leftIndex, mid - 1);
        sort(nums, mid + 1, rightIndex);
    }

    private int partition(final int[] nums, final int leftIndex, final int rightIndex) {
        int pivotIndex = new Random().nextInt(rightIndex - leftIndex + 1) + leftIndex;
        int pivot = nums[pivotIndex];
        int left = leftIndex + 1;
        int right = rightIndex;
        while (left <= right) {
            while (left < rightIndex && nums[left] <= pivot) {
                left++;
            }
            while (right > leftIndex && nums[right] > pivot) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(nums, left, right);
        }
        swap(nums, leftIndex, right);
        return right;
    }

    private void swap(final int[] nums, final int left, final int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
