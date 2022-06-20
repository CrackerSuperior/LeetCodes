package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 1379: Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
 */
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    private TreeNode result;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || result != null) {
            return null;
        }
        if (original == target) {
            result = cloned;
            return result;
        }
        getTargetCopy(original.left, cloned.left, target);
        getTargetCopy(original.right, cloned.right, target);
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
