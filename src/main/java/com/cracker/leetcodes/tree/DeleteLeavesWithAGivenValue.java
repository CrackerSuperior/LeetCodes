package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 1325: Delete Leaves With a Given Value.
 */
public class DeleteLeavesWithAGivenValue {

    public TreeNode removeLeafNodes(final TreeNode root, final int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}
