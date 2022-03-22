package com.cracker.leetcodes.math;

/**
 * This is Leetcode number 69: Sqrt(x).
 */
public class SquareRoot {

    public int mySqrt(final int x) {
        int l = 0;
        int r = x;
        int result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long number = (long) mid * mid;
            if (number <= x) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    public int mySqrtPlus(final int x) {
        long y = x;
        while (y * y > x) {
            y = (x / y + y) / 2;
        }
        return (int) y;
    }
}
