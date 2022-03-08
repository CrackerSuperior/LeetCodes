package com.cracker.leetcodes;

/**
 * This is Leetcode number 7: Integer inversion.
 */
public class IntegerInversion {

    public int reverse(final int x) {
        int result;
        long temp;
        if (x < 0) {
            temp = Long.parseLong("-" + new StringBuilder(String.valueOf(x).substring(1)).reverse());
        } else {
            temp = Long.parseLong("" + new StringBuilder(String.valueOf(x)).reverse());
        }
        result = (int) temp;
        return result == temp ? result : 0;
    }
}
