package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 563. Binary Tree Tilt.
 */
public class BinaryTreeTilt {

    private int result;

    public int findTilt(final TreeNode root) {
        dp(root);
        return result;
    }

    private int dp(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dp(root.left);
        int right = dp(root.right);
        result += Math.abs(left - right);
        return left + right + root.val;
    }
}
