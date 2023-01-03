package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 572: Subtree of Another Tree.
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(final TreeNode root, final TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        if (dp(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean dp(final TreeNode root, final TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return root.val == subRoot.val && dp(root.left, subRoot.left) && dp(root.right, subRoot.right);
    }
}
