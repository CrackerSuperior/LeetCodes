package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 513: Find Bottom Left Tree Value.
 */
public class FindBottomLeftTreeValue {

    private int maxDepth;
    
    private int depth;

    private int result;
    
    public int findBottomLeftValue(final TreeNode root) {
        dp(root);
        return result;
    }

    private void dp(final TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (depth > maxDepth) {
            maxDepth = depth;
            result = root.val;
        }
        dp(root.left);
        dp(root.right);
        depth--;
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
