package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 344: Reverse String.
 */
public class ReverseString {

    public void reverseString(final char[] s) {
        int slow = 0;
        int fast = s.length - 1;
        while (fast - slow >= 1) {
            char temp = s[slow];
            s[slow] = s[fast];
            s[fast] = temp;
            fast--;
            slow++;
        }
    }
}
