package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 100: Same Tree.
 */
public class SameTree {

    public boolean isSameTree(final TreeNode p, final TreeNode q) {
        return dp(p, q);
    }

    private boolean dp(final TreeNode p, final TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        return dp(p.left, q.left) && dp(p.right, q.right) && p.val == q.val;
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
