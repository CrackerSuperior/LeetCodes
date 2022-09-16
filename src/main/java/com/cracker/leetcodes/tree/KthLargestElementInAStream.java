package com.cracker.leetcodes.tree;

import java.util.PriorityQueue;

/**
 * This is Leetcode number 703: Kth Largest Element in a Stream.
 */
public class KthLargestElementInAStream {

    static class KthLargest {
        
        private int k;
        
        private final PriorityQueue<Integer> results = new PriorityQueue<>(); 

        KthLargest(final int k, final int[] nums) {
            for (int num : nums) {
                results.offer(num);
                if (results.size() > k) {
                    results.poll();
                }
            }
            this.k = k;
        }

        public int add(final int val) {
            results.offer(val);
            if (results.size() > k) {
                results.poll();
            }
            return results.peek();
        }
    }
}
