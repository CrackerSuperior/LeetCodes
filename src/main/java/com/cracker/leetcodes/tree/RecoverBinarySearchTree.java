package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 99: Recover Binary Search Tree.
 */
public class RecoverBinarySearchTree {

    private TreeNode first;
    
    private TreeNode second;
    
    private TreeNode min = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(final TreeNode root) {
        dp(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void dp(final TreeNode root) {
        if (root == null) {
            return;
        }
        dp(root.left);
        if (root.val < min.val) {
            if (first == null) {
                first = min;
            } 
            second = root;
        }
        min = root;
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
