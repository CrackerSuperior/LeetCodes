package com.cracker.leetcodes.tree;

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

    public class TreeNode {

        private int val;

        private TreeNode left;

        private TreeNode right;

        TreeNode() { }

        TreeNode(final int val) {
            this.val = val;
        }

        TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
