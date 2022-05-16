package com.cracker.leetcodes.array;

import java.util.Arrays;

/**
 * This is Leetcode number 1011: Capacity To Ship Packages Within D Days.
 */
public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(final int[] weights, final int days) {
        int left = Arrays.stream(weights).max().orElse(0);
        int right = Arrays.stream(weights).sum();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(final int[] weights, final int target) {
        int days = 0;
        for (int i = 0; i < weights.length;) {
            int cap = target;
            while (i < weights.length) {
                if (cap < weights[i]) {
                    break;
                } else {
                    cap -= weights[i++];
                }
            }
            days++;
        }
        return days;
    }
}
