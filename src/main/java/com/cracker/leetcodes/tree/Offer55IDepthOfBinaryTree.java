package com.cracker.leetcodes.tree;

/**
 * This is Leetcode Offer 55 - I. Depth of Binary Tree.
 */
public class Offer55IDepthOfBinaryTree {

    private int result;

    private int depth;

    public int maxDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth++;
        result = Math.max(result, depth);
        maxDepth(root.left);
        maxDepth(root.right);
        depth--;
        return result;
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
