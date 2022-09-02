package com.cracker.leetcodes.string;

/**
 * This is Leetcode number 383: Ransom Note.
 */
public class RansomNote {

    public boolean canConstruct(final String ransomNote, final String magazine) {
        char[] chars = magazine.toCharArray();
        String temp = ransomNote;
        for (char c : chars) {
            temp = temp.replaceFirst(c + "", "");
        }
        return temp.isEmpty();
    }

    public boolean canConstructPlus(final String ransomNote, final String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (arr[index] > 0) {
                arr[index]--;
            } else {
                return false;
            }
        }
        return true;
    }
}
