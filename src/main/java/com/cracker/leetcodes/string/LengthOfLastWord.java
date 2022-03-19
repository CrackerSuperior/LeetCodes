package com.cracker.leetcodes.string;

/**
 * This is Leetcode number 58: Length of Last Word.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(final String s) {
        String[] split = s.trim().split(" ");
        return split[split.length - 1].trim().length();
    }
}
