package com.cracker.leetcodes.string;

/**
 * This is Leetcode number 28: Implement strStr().
 */
public class ImplementStrStr {

    public int strStr(final String haystack, final String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        return new KMP(needle).search(haystack);
    }

    private static class KMP {

        private int[][] dp;

        private final String substring;

        KMP(final String substring) {
            this.substring = substring;
            int subLen = substring.length();
            buildDP(substring, subLen);
        }

        private void buildDP(final String substring, final int subLen) {
            this.dp = new int[subLen][256];
            this.dp[0][substring.charAt(0)] = 1;
            int x = 0;
            for (int i = 1; i < subLen; i++) {
                System.arraycopy(this.dp[x], 0, this.dp[i], 0, 256);
                this.dp[i][substring.charAt(i)] = i + 1;
                x = this.dp[x][substring.charAt(i)];
            }
        }

        public int search(final String str) {
            int subLen = substring.length();
            int len = str.length();
            int j = 0;
            for (int i = 0; i < len; i++) {
                j = dp[j][str.charAt(i)];
                if (j == subLen) {
                    return i - subLen + 1;
                }
            }
            return -1;
        }
    }
}
