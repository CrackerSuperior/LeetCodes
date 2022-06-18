package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 700: Search in a Binary Search Tree.
 */
public class SearchInABinarySearchTree {

    public TreeNode searchBST(final TreeNode root, final int val) {
        if (root == null) {
            return null;
        }
        TreeNode result = null;
        if (root.val == val) {
            result = root;
        }
        if (root.val < val) {
            result = searchBST(root.right, val);
        }
        if (root.val > val) {
            result = searchBST(root.left, val);
        }
        return result;
    }

    public TreeNode searchBSTPlus(final TreeNode root, final int val) {
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return node;
            }
            node = node.val < val ? node.right : node.left;
        }
        return null;
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
