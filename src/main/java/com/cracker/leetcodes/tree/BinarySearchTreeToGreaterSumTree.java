package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 1038: Binary Search Tree to Greater Sum Tree.
 *      This question is the same as leetcode's 538 questions.
 */
public class BinarySearchTreeToGreaterSumTree {

    private int sum;

    public TreeNode bstToGst(final TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
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
