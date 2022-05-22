package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 965: Univalued Binary Tree.
 */
public class UnivaluedBinaryTree {

    private int mark;

    public boolean isUnivalTree(final TreeNode root) {
        if (root == null) {
            return true;
        }
        mark = root.val;
        return dp(root);
    }

    private boolean dp(final TreeNode root) {
        if (root == null) {
            return true;
        }
        return root.val == mark && dp(root.left) && dp(root.right);
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
