package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 543: Diameter of Binary Tree.
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] maxDiameter = {0};
        maxLength(root, maxDiameter);
        return maxDiameter[0];
    }

    private int maxLength(final TreeNode root, final int[] maxDiameter) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxLength(root.left, maxDiameter);
        int maxRight = maxLength(root.right, maxDiameter);
        int maxLength = maxLeft + maxRight;
        maxDiameter[0] = Math.max(maxLength, maxDiameter[0]);
        return Math.max(maxLeft, maxRight) + 1;
    }
}
