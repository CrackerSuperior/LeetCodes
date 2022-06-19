package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 700: Search in a Binary Search Tree.
 */
public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(final TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = increasingBST(root.left);
        root.left = null;
        root.right = increasingBST(root.right);
        if (left == null) {
            return root;
        }
        TreeNode node = left;
        while (node.right != null) {
            node = node.right;
        }
        node.right = root;
        return left;
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
