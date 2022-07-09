package com.cracker.leetcodes.tree;

/**
 * This is Leetcode Offer 054: The kth largest node of the binary search tree.
 */
public class OfferTheKthLargestNodeOfTheBinarySearchTree {

    private int num;

    private int result;

    public int kthLargest(final TreeNode root, final int k) {
        if (root == null) {
            return 0;
        }
        kthLargest(root.right, k);
        if (++num == k) {
            result = root.val;
        }
        kthLargest(root.left, k);
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
