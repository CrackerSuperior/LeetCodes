package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 1026: Maximum Difference Between Node and Ancestor.
 */
public class MaximumDifferenceBetweenNodeAndAncestor {

    private int result;

    public int maxAncestorDiff(final TreeNode root) {
        dp(root);
        return result;
    }

    private int[] dp(final TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
        int[] leftMaxMin;
        int[] rightMaxMin;
        leftMaxMin = dp(root.left);
        rightMaxMin = dp(root.right);
        int max = max(root.val, leftMaxMin[0], rightMaxMin[0]);
        int min = min(root.val, leftMaxMin[1], rightMaxMin[1]);
        result = max(result, Math.abs(root.val - max), Math.abs(root.val - min));
        return new int[] {max, min};
    }

    private int max(final int a, final int b, final int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int min(final int a, final int b, final int c) {
        return Math.min(Math.min(a, b), c);
    }
}
