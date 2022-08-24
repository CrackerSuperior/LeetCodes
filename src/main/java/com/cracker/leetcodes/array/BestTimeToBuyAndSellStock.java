package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 121: Best Time to Buy and Sell Stock.
 */
public class BestTimeToBuyAndSellStock {
    
    public int maxProfit(final int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (min > price) {
                min = price;
            } else if (price - min > max) {
                max = price - min;
            }
        }
        return max;
    }
}
