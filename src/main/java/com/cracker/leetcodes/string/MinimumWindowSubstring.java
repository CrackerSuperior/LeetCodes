package com.cracker.leetcodes.string;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 76: Minimum Window Substring.
 */
public class MinimumWindowSubstring {

    public String minWindow(final String s, final String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] chars = t.toCharArray();
        for (char c : chars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        char[] sChar = s.toCharArray();
        while (right < sChar.length) {
            char c = sChar[right++];
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = sChar[left++];
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, len);
    }
}
