package com.cracker.leetcodes.tree;

/**
 * This is Leetcode Offer II 54: The sum of all values greater than or equal to the node.
 *      This question is the same as leetcode's 538 and 1038 questions.
 */
public class OfferII54SumOfAllValuesGreaterThanOrEqualToNode {

    private int sum;

    public TreeNode convertBST(final TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
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
