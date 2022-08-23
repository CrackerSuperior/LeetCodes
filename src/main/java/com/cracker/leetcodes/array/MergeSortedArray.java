package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 88: Merge Sorted Array.
 */
public class MergeSortedArray {

    public void merge(final int[] nums1, final int m, final int[] nums2, final int n) {
        int[] nums = new int[m + n];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        int i = 0;
        int j = 0;
        int l = 0;
        while (i < m && j < n) {
            if (nums[i] < nums2[j]) {
                nums1[l++] = nums[i++];
            } else {
                nums1[l++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[l++] = nums[i++];
        }
        while (j < n) {
            nums1[l++] = nums2[j++];
        }
    }

    public void mergePlus(final int[] nums1, final int m, final int[] nums2, final int n) {
        int i = m - 1;
        int j = n - 1;
        int l = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[l--] = nums1[i--];
            } else {
                nums1[l--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[l--] = nums2[j--];
        }
    }
}
