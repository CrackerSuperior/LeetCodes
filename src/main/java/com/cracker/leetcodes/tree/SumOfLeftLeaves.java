package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 404: Sum of Left Leaves.
 */
public class SumOfLeftLeaves {

    private int result;

    public int sumOfLeftLeaves(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        dp(root);
        return result;
    }

    private void dp(final TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            result += root.left.val;
        }
        dp(root.left);
        dp(root.right);
    }
}
