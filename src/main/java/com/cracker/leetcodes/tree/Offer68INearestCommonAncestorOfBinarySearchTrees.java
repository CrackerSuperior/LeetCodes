package com.cracker.leetcodes.tree;

/**
 * This is Leetcode Offer 68 - I: Nearest Common Ancestor of Binary Search Trees.
 *      This question is the same as leetcode's 235 questions.
 */
public class Offer68INearestCommonAncestorOfBinarySearchTrees {

    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        if (p.val >= root.val && q.val <= root.val) {
            return root;
        }
        if (p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
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
