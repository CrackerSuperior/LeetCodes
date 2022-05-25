package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 623: Add One Row to Tree.
 */
public class AddOneRowToTree {

    public TreeNode addOneRow(final TreeNode root, final int val, final int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        if (depth == 2) {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
            return root;
        }
        addOneRow(root.left, val, depth - 1);
        addOneRow(root.right, val, depth - 1);
        return root;
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
