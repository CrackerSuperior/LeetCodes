package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 1109: Corporate Flight Bookings.
 */
public class CorporateFlightBookings {

    public int[] corpFlightBookings(final int[][] bookings, final int n) {
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            diff[booking[0] - 1] += booking[2];
            if (booking[1] < diff.length) {
                diff[booking[1]] -= booking[2];
            }
        }
        int[] result = new int[n];
        result[0] = diff[0];
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }
}
