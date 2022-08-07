package com.cracker.leetcodes.tree;

/**
 * This is Leetcode Offer II 052: Flattening the binary search tree.
 *      This question is the same as leetcode's 897 questions.
 */
public class OfferII052FlatteningTheBinarySearchTree {

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
