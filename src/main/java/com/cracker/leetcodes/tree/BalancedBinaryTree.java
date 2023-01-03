package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 110: Balanced Binary Tree.
 */
public class BalancedBinaryTree {

    private boolean isBalance = true;

    public boolean isBalanced(final TreeNode root) {
        dp(root);
        return isBalance;
    }

    private int dp(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        // TODO When the variable A is false, directly end the recursion.
        int left = dp(root.left);
        int right = dp(root.right);
        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }
        return 1 + Math.max(left, right);
    }
}
