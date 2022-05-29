package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 563. Binary Tree Tilt.
 */
public class BinaryTreeTilt {

    private int result;

    public int findTilt(final TreeNode root) {
        dp(root);
        return result;
    }

    private int dp(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dp(root.left);
        int right = dp(root.right);
        result += Math.abs(left - right);
        return left + right + root.val;
    }

    static class TreeNode {

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
