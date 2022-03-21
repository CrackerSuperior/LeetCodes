package com.cracker.leetcodes.array;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This is Leetcode number 67: Add Binary.
 */
public class AddBinary {

    public String addBinary(final String a, final String b) {
        char[] len = a.length() >= b.length() ? a.toCharArray() : b.toCharArray();
        char[] sho = a.length() < b.length() ? a.toCharArray() : b.toCharArray();
        int[] result = new int[len.length];
        for (int i = sho.length - 1; i >= 0; i--) {
            int j = i + (len.length - sho.length);
            result[j] = (len[j] - 48) + (sho[i] - 48);
        }
        for (int i = len.length - sho.length - 1; i >= 0; i--) {
            result[i] = len[i] - 48;
        }
        for (int i = result.length - 1; i > 0; i--) {
            if (result[i] >= 2) {
                result[i] %= 2;
                result[i - 1]++;
            }
        }
        if (result[0] >= 2) {
            int[] temp = new int[result.length + 1];
            temp[0] = 1;
            result[0] %= 2;
            System.arraycopy(result, 0, temp, 1, result.length);
            result = temp;
        }
        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    public String addBinaryPlus(final String a, final String b) {
        StringBuilder result = new StringBuilder();
        int len = Math.max(a.length(), b.length());
        int math = 0;
        for (int i = 0; i < len; i++) {
            math += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            math += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            result.append(math % 2);
            math /= 2;
        }
        if (math != 0) {
            result.append(math);
        }
        return result.reverse().toString();
    }
}
