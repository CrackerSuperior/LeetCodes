package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 66: PlusOne.
 */
public class PlusOne {

    public int[] plusOne(final int[] digits) {
        int mark = -1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                mark = i;
                break;
            } else {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        if (mark == -1) {
            result[0] = 1;
        } else {
            digits[mark]++;
        }
        return mark == -1 ? result : digits;
    }
}
