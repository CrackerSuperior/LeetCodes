package com.cracker.leetcodes.tree;

/**
 * This is Leetcode Offer II 045: The bottommost leftmost value of the binary tree.
 *      This question is the same as leetcode's 513 questions.
 */
public class OfferII045TheBottommostLeftmostValueOfTheBinaryTree {
    
    private int result;
    
    private int depth;
    
    private int maxDepth;

    public int findBottomLeftValue(final TreeNode root) {
        dp(root);
        return result;
    }
    
    private void dp(final TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (maxDepth < depth) {
            result = root.val;
            maxDepth = depth;
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
