package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 96: Unique Binary Search Trees.
 */
public class UniqueBinarySearchTrees {

    private int[][] results;

    public int numTrees(final int n) {
        results = new int[n + 1][n + 1];
        return count(1, n);
    }

    private int count(final int left, final int right) {
        if (left > right) {
            return 1;
        }
        if (results[left][right] != 0) {
            return results[left][right];
        }
        int result = 0;
        for (int mid = left; mid <= right; mid++) {
            int leftResult = count(left, mid - 1);
            int rightResult = count(mid + 1, right);
            result += leftResult * rightResult;
        }
        results[left][right] = result;
        return result;
    }
}
