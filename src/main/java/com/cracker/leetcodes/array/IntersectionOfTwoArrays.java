package com.cracker.leetcodes.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is Leetcode number 349: Intersection of Two Arrays.
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(final int[] nums1, final int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left = 0;
        int right = 0;
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] == nums2[right]) {
                result.add(nums1[left]);
                left++;
                right++;
            } else if (nums1[left] < nums2[right]) {
                left++;
            } else if (nums1[left] > nums2[right]) {
                right++;
            }
        }
        return result.stream().mapToInt(each -> each).toArray();
    }

    public int[] intersectionPlus(final int[] nums1, final int[] nums2) {
        int[] mark = new int[1000];
        for (int i : nums1) {
            mark[i]++;
        }
        int[] result = new int[nums1.length];
        int num = 0;
        for (int i : nums2) {
            if (mark[i] != 0) {
                result[num] = i;
                num++;
                mark[i] = 0;
            }
        }
        return Arrays.copyOf(result, num);
    }
}
