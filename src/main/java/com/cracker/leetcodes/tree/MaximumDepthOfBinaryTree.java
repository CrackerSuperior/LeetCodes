package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 104: Maximum Depth of Binary Tree.
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max;
        max = Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        return max;
    }
}
