package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 543: Diameter of Binary Tree.
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = {0};
        maxDiameter(root, max);
        return max[0];
    }

    private void maxDiameter(final TreeNode root, final int[] max) {
        if (root == null) {
            return;
        }
        int maxLeft;
        int maxRight;
        maxLeft = maxLength(root.left);
        maxRight = maxLength(root.right);
        int maxDiameter = maxLeft + maxRight;
        max[0] = Math.max(maxDiameter, max[0]);
        maxDiameter(root.left, max);
        maxDiameter(root.right, max);
    }

    private int maxLength(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max;
        max = Math.max(maxLength(root.right) + 1, maxLength(root.left) + 1);
        return max;
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
