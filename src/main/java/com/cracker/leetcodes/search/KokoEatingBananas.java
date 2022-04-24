package com.cracker.leetcodes.search;

/**
 * This is Leetcode number 875: Koko Eating Bananas.
 */
public class KokoEatingBananas {

    public int minEatingSpeed(final int[] piles, final int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            if (right < pile) {
                right = pile;
            }
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int f = f(piles, mid);
            if (h >= f) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private int f(final int[] piles, final int x) {
        int result = 0;
        for (int i = 0; i < piles.length; i++) {
            result += piles[i] / x;
            if (piles[i] % x > 0) {
                result++;
            }
        }
        return result;
    }
}
