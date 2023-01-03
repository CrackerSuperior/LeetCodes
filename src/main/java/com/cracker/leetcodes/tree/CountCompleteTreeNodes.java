package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 222: Count Complete Tree Nodes.
 */
public class CountCompleteTreeNodes {

    public int countNodes(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int countNodesPlus(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root;
        TreeNode right = root;
        int leftHigh = 0;
        int rightHigh = 0;
        while (left != null) {
            left = left.left;
            leftHigh++;
        }
        while (right != null) {
            right = right.right;
            rightHigh++;
        }
        if (leftHigh == rightHigh) {
            return (int) Math.pow(2, leftHigh) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
