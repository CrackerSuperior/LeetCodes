package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 998: Maximum Binary Tree II.
 */
public class MaximumBinaryTreeII {

    public TreeNode insertIntoMaxTree(final TreeNode root, final int val) {
        return build(root, val);
    }

    private TreeNode build(final TreeNode root, final int val) {
        TreeNode node = root;
        if (node == null) {
            return new TreeNode(val);
        }
        if (node.val < val) {
            TreeNode temp = node;
            node = new TreeNode(val);
            node.left = temp;
        } else {
            node.right = build(node.right, val);
        }
        return node;
    }

    public class TreeNode {

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
