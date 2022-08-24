package com.cracker.leetcodes.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is Leetcode number 350: Intersection of Two Arrays II.
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(final int[] nums1, final int[] nums2) {
        List<Integer> nums1List = new ArrayList<>();
        for (int num : nums1) {
            nums1List.add(num);
        }
        int[] result = new int[nums1.length + nums2.length];
        int l = 0;
        for (int num : nums2) {
            if (nums1List.contains(num)) {
                result[l++] = num;
                nums1List.remove((Integer) num);
            }
        }
        return Arrays.copyOf(result, l);
    }

    public int[] intersectPlus(final int[] nums1, final int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int l = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result[l++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(result, l);
    }

    public int[] intersectPlusPlus(final int[] nums1, final int[] nums2) {
        int[] nums = new int[1000];
        for (int num : nums1) {
            nums[num]++;
        }
        int[] result = new int[nums1.length + nums2.length];
        int l = 0;
        for (int num : nums2) {
            if (nums[num] > 0) {
                result[l++] = num;
                nums[num]--;
            }
        }
        return Arrays.copyOf(result, l);
    }
}
