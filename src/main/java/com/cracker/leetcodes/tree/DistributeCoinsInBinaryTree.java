package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 979: Distribute Coins in Binary Tree.
 */
public class DistributeCoinsInBinaryTree {

    private int result;

    public int distributeCoins(final TreeNode root) {
        result = 0;
        dp(root);
        return result;
    }

    private int dp(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dp(root.left);
        int right = dp(root.right);
        result += Math.abs(left) + Math.abs(right) + root.val - 1;
        return left + right + root.val - 1;
    }
}
