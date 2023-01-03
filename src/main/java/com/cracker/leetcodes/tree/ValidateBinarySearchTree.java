package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 98: Validate Binary Search Tree.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(final TreeNode root) {
        return dp(root, null, null);
    }

    private boolean dp(final TreeNode root, final TreeNode max, final TreeNode min) {
        if (root == null) {
            return true;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        return dp(root.left, root, min) && dp(root.right, max, root);
    }
}
