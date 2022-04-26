package com.cracker.leetcodes.string;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 567: Permutation in String.
 */
public class PermutationInString {

    public boolean checkInclusion(final String s1, final String s2) {
        Map<Character, Integer> subStr = new HashMap<>();
        Map<Character, Integer> str = new HashMap<>();
        for (char c : s1.toCharArray()) {
            subStr.put(c, subStr.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        char[] chars = s2.toCharArray();
        while (right < chars.length) {
            char c = chars[right++];
            if (subStr.containsKey(c)) {
                str.put(c, str.getOrDefault(c, 0) + 1);
                if (subStr.get(c).equals(str.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == subStr.size()) {
                    return true;
                }
                char aChar = chars[left++];
                if (subStr.containsKey(aChar)) {
                    if (str.get(aChar).equals(subStr.get(aChar))) {
                        valid--;
                    }
                    str.put(aChar, str.get(aChar) - 1);
                }
            }
        }
        return false;
    }
}
