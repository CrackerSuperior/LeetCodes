package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 2236: Root Equals Sum of Children.
 */
public class RootEqualsSumOfChildren {

    public boolean checkTree(final TreeNode root) {
        return root.val == root.left.val + root.right.val;
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
