package com.cracker.leetcodes.string;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 3: Longest Substring Without Repeating Characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(final String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        char[] chars = s.toCharArray();
        while (right < s.length()) {
            char aChar = chars[right++];
            window.put(aChar, window.getOrDefault(aChar, 0) + 1);
            while (window.get(aChar) > 1) {
                char c = chars[left];
                if (window.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) - 1);
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
