package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 1080: Insufficient Nodes in Root to Leaf Paths.
 */
public class InsufficientNodesInRootToLeafPaths {

    public TreeNode sufficientSubset(final TreeNode root, final int limit) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            if (root.val < limit) {
                return null;
            }
            return root;
        }
        TreeNode left = sufficientSubset(root.left, limit - root.val);
        TreeNode right = sufficientSubset(root.right, limit - root.val);
        if (left == null && right == null) {
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
