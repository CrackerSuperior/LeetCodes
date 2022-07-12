package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 230: Kth Smallest Element in a BST.
 */
public class KthSmallestElementInABST {

    private int result;

    private int rank;

    public int kthSmallest(final TreeNode root, final int k) {
        dp(root, k);
        return result;
    }

    private void dp(final TreeNode root, final int k) {
        if (root == null) {
            return;
        }
        dp(root.left, k);
        if (++rank == k) {
            result = root.val;
            return;
        }
        dp(root.right, k);
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
