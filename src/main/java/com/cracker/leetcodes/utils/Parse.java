package com.cracker.leetcodes.utils;

public class Parse {

    public static int parseInt(final String s) {
        int len = s.length();
        int i = 0;
        int result = 0;
        boolean negative = false;
        if (s.charAt(0) == '-') {
            negative = true;
            i++;
        }
        while (i < len) {
            int digit = s.charAt(i++) - '0';
            result *= 10;
            result -= digit;
        }
        return negative ? result : -result;
    }
}
