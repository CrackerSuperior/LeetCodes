package com.cracker.leetcodes.string;

/**
 * This is Leetcode number 9: Is Palindrome.
 */
public class Palindrome {

    public boolean isPalindrome(final int x) {
        if (x < 0) {
            return false;
        }
        return x == Long.parseLong(String.valueOf(new StringBuilder(String.valueOf(x)).reverse()));
    }

    public boolean isPalindromePlus(final int x) {
        int z = x;
        if (z < 0 || (z % 10 == 0 && z != 0)) {
            return false;
        }
        int y = 0;
        while (z > y) {
            y = y * 10 + z % 10;
            z = z / 10;
        }
        return z == y || z == y / 10;
    }
}
