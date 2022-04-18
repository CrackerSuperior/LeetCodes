package com.cracker.leetcodes.string;

/**
 * This is Leetcode number 5: Longest Palindromic Substring.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(final String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String leftStr = isPalindrome(s, i, i);
            String rightStr = isPalindrome(s, i, i + 1);
            result = result.length() > leftStr.length() ? result : leftStr;
            result = result.length() > rightStr.length() ? result : rightStr;
        }
        return result;
    }

    String isPalindrome(final String str, final int left, final int right) {
        int tLeft = left;
        int tRight = right;
        while (tLeft >= 0 && tRight < str.length()) {
            if (str.charAt(tLeft) != str.charAt(tRight)) {
                break;
            }
            tLeft--;
            tRight++;
        }
        return str.substring(tLeft + 1, tRight);
    }
}
