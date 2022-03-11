package com.cracker.leetcodes.string;

/**
 * This is Leetcode number 14: Longest Common Prefix.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(final String[] strs) {
        if ("".equals(strs[0])) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < result.length() && j < strs[i].length(); j++) {
                if (result.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            result = result.substring(0, j);
            if ("".equals(result)) {
                return result;
            }
        }
        return result;
    }
}
