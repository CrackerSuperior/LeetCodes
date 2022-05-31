package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 938: Range Sum of BST.
 */
public class RangeSumOfBST {

    public int rangeSumBST(final TreeNode root, final int low, final int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
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
