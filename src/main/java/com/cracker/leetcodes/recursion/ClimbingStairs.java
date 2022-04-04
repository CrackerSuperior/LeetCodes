package com.cracker.leetcodes.recursion;

/**
 * This is Leetcode number 70: Climbing Stairs.
 */
public class ClimbingStairs {

    public int climbStairs(final int n) {
        int start = 0;
        int middle = 0;
        int end = 1;
        for (int i = 1; i < n; i++) {
            start = middle;
            middle = end;
            end = start + middle;
        }
        return end;
    }
}
