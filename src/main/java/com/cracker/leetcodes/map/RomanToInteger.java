package com.cracker.leetcodes.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This is Leetcode number 13: Roman to Integer.
 */
public class RomanToInteger {

    public int romanToInt(final String s) {
        Map<String, Integer> singleLetter = new HashMap<>();
        singleLetter.put("I", 1);
        singleLetter.put("V", 5);
        singleLetter.put("X", 10);
        singleLetter.put("L", 50);
        singleLetter.put("C", 100);
        singleLetter.put("D", 500);
        singleLetter.put("M", 1000);
        Map<String, Integer> moreLetter = new HashMap<>();
        moreLetter.put("IV", 4);
        moreLetter.put("IX", 9);
        moreLetter.put("XL", 40);
        moreLetter.put("XC", 90);
        moreLetter.put("CD", 400);
        moreLetter.put("CM", 900);
        String[] temp = {s};
        moreLetter.forEach((key, value) -> {
            if (temp[0].contains(key)) {
                temp[0] = temp[0].replace(key, value + "-");
            }
        });
        singleLetter.forEach((key, value) -> {
            if (temp[0].contains(key)) {
                temp[0] = temp[0].replace(key, value + "-");
            }
        });
        String[] split = temp[0].split("-");
        List<Integer> collect = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
        return collect.stream().mapToInt(each -> each).sum();
    }

    public int romanToIntPlus(final String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (getValue(chars[i]) < getValue(chars[i + 1])) {
                result -= getValue(chars[i]);
            } else {
                result += getValue(chars[i]);
            }
        }
        return result + getValue(chars[chars.length - 1]);
    }

    private int getValue(final Character character) {
        switch (character) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
