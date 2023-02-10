package com.cracker.leetcodes.string;

/**
 * This is Leetcode number 8: String to Integer (atoi).
 */
public class StringToInteger {

    public int myAtoi(final String s) {
        int length = s.length();
        int sign = 1;
        int index = 0;
        long result = 0;
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }
        if (index == length) {
            return 0;
        }
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        if (index == length) {
            return 0;
        }
        while (index < length && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            result = result * 10 + s.charAt(index) - '0';
            if (result > 0x7fffffff) {
                break;
            }
            index++;
        }
        if (((int) result) != result) {
            return sign == 1 ? 0x7fffffff : 0x80000000;
        }
        return sign * ((int) result);
    }
}
