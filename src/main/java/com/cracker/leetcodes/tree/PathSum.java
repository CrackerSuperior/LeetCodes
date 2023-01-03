package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 112: Path Sum.
 */
public class PathSum {

    public boolean hasPathSum(final TreeNode root, final int targetSum) {
        if (root == null) {
            return false;
        }
        int sum = targetSum - root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
