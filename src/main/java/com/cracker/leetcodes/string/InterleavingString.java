package com.cracker.leetcodes.string;

import java.util.Arrays;

/**
 * This is Leetcode number 97: Interleaving String.
 */
public class InterleavingString {

    private int[][] mark;

    public boolean isInterleave(final String s1, final String s2, final String s3) {
        int x = s1.length();
        int y = s2.length();
        if (x + y != s3.length()) {
            return false;
        }
        mark = new int[x + 1][y + 1];
        for (int[] ints : mark) {
            Arrays.fill(ints, -1);
        }
        return dp(s1, s2, s3, 0, 0);
    }

    private boolean dp(final String s1, final String s2, final String s3, final int left, final int right) {
        int k = left + right;
        if (k == s3.length()) {
            return true;
        }
        if (mark[left][right] != -1) {
            return mark[left][right] == 1;
        }
        boolean result = false;
        if (left < s1.length() && s1.charAt(left) == s3.charAt(k)) {
            result = dp(s1, s2, s3, left + 1, right);
        }
        if (right < s2.length() && s2.charAt(right) == s3.charAt(k)) {
            result = result || dp(s1, s2, s3, left, right + 1);
        }
        mark[left][right] = result ? 1 : 0;
        return result;
    }
}
