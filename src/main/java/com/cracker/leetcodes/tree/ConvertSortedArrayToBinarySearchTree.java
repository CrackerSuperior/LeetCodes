package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 108: Convert Sorted Array to Binary Search Tree.
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(final int[] nums) {
        return dp(nums, 0, nums.length - 1);
    }

    private TreeNode dp(final int[] nums, final int left, final int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dp(nums, left, mid - 1);
        root.right = dp(nums, mid + 1, right);
        return root;
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
