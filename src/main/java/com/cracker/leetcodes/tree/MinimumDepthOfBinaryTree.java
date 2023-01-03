package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 111: Minimum Depth of Binary Tree.
 */
public class MinimumDepthOfBinaryTree {

    private int minDepth;

    public int minDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDepth = Integer.MAX_VALUE;
        dp(root, 1);
        return minDepth;
    }

    private void dp(final TreeNode root, final int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, depth);
            return;
        }
        dp(root.left, depth + 1);
        dp(root.right, depth + 1);
    }
}
