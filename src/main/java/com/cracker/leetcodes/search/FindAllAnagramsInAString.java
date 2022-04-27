package com.cracker.leetcodes.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is Leetcode number 438: Find All Anagrams in a String.
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(final String s, final String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        char[] chars = s.toCharArray();
        List<Integer> result = new ArrayList<>();
        while (right < s.length()) {
            char aChar = chars[right++];
            if (need.containsKey(aChar)) {
                window.put(aChar, window.getOrDefault(aChar, 0) + 1);
                if (need.get(aChar).equals(window.get(aChar))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                char c = chars[left];
                if (right - left == p.length()) {
                    result.add(left);
                }
                if (need.containsKey(c)) {
                    if (need.get(c).equals(window.get(c))) {
                        valid--;
                    }
                    window.put(c, window.get(c) - 1);
                }
                left++;
            }
        }
        return result;
    }
}
