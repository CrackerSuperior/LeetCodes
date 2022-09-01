package com.cracker.leetcodes.map;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 387: First Unique Character in a String.
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(final String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
