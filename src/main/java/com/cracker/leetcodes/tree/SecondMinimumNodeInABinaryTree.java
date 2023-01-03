package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 671: Second Minimum Node In a Binary Tree.
 */
public class SecondMinimumNodeInABinaryTree {

    public int findSecondMinimumValue(final TreeNode root) {
        if (root.left == null || root.right == null) {
            return -1;
        }
        int left = root.left.val;
        int right = root.right.val;
        if (root.val == root.left.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (root.val == root.right.val) {
            right = findSecondMinimumValue(root.right);
        }
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return Math.min(left, right);
    }
}
