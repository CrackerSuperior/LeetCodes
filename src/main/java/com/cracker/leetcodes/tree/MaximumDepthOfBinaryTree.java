package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 104: Maximum Depth of Binary Tree.
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max;
        max = Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        return max;
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
