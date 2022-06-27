package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 404: Sum of Left Leaves.
 */
public class SumOfLeftLeaves {

    private int result;

    public int sumOfLeftLeaves(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        dp(root);
        return result;
    }

    private void dp(final TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            result += root.left.val;
        }
        dp(root.left);
        dp(root.right);
    }

    public static class TreeNode {

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
