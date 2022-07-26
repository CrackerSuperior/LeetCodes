package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 783: Minimum Distance Between BST Nodes.
 *      This question is the same as leetcode's 530 question.
 */
public class MinimumDistanceBetweenBSTNodes {
    
    private int result = Integer.MAX_VALUE;
    
    private TreeNode prev;

    public int minDiffInBST(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDiffInBST(root.left);
        if (null != prev) {
            result = Math.min(result, Math.abs(root.val - prev.val));
        } 
        prev = root;
        minDiffInBST(root.right);
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
