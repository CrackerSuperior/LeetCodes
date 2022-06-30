package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 1080: Insufficient Nodes in Root to Leaf Paths.
 */
public class InsufficientNodesInRootToLeafPaths {

    public TreeNode sufficientSubset(final TreeNode root, final int limit) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.val < limit) {
                return null;
            }
            return root;
        }
        TreeNode left = sufficientSubset(root.left, limit - root.val);
        TreeNode right = sufficientSubset(root.right, limit - root.val);
        if (left == null && right == null) {
            return null;
        }
        root.left = left;
        root.right = right;
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
