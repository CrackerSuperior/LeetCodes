package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 1372: Longest ZigZag Path in a Binary Tree.
 */
public class LongestZigZagPathInABinaryTree {
    
    private int result;

    public int longestZigZag(final TreeNode root) {
        dp(root);
        return result;
    }
    
    private int[] dp(final TreeNode root) {
        if (root == null) {
            return new int[]{-1, -1};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int leftStaggeredPath = left[1] + 1;
        int rightStaggeredPath = right[0] + 1;
        result = Math.max(result, Math.max(leftStaggeredPath, rightStaggeredPath));
        return new int[]{leftStaggeredPath, rightStaggeredPath};
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
