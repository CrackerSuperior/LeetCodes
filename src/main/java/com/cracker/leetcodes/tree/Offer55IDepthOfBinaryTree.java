package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode Offer 55 - I. Depth of Binary Tree.
 */
public class Offer55IDepthOfBinaryTree {

    private int result;

    private int depth;

    public int maxDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth++;
        result = Math.max(result, depth);
        maxDepth(root.left);
        maxDepth(root.right);
        depth--;
        return result;
    }
}
