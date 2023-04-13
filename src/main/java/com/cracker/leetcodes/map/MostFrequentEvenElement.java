package com.cracker.leetcodes.map;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 2404: Most Frequent Even Element.
 */
public class MostFrequentEvenElement {

    public int mostFrequentEven(final int[] nums) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                temp.put(num, temp.getOrDefault(num, 0) + 1); 
            }
        }
        int max = -1;
        int maxV = 0;
        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
            if (maxV < entry.getValue() || (maxV == entry.getValue() && max > entry.getKey())) {
                maxV = entry.getValue();
                max = entry.getKey();
            }
        }
        return max;
    }
    
    public int mostFrequentEvenPlus(final int[] nums) {
        int[] temp = new int[50001];
        int result = -1;
        int max = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                int count = ++temp[num >> 1];
                if (max < count) {
                    max = count;
                    result = num;
                } else if (max == count && result > num) {
                    result = num;
                }
            }
        }
        return result;
    }
}
