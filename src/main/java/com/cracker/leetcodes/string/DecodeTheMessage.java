package com.cracker.leetcodes.string;

/**
 * This is Leetcode number 2325: Decode the Message.
 */
public class DecodeTheMessage {

    public String decodeMessage(final String key, final String message) {
        char[] keyChar = new char[26];
        char letter = 'a';
        for (char c : key.toCharArray()) {
            int i = c - 'a';
            if ((i >= 0 && i <= 25) && keyChar[i] == 0) {
                keyChar[i] = letter++;
            }
        }
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[i] = keyChar[chars[i] - 'a'];
            }
        }
        return new String(chars);
    }
}
