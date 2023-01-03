package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 965: Univalued Binary Tree.
 */
public class UnivaluedBinaryTree {

    private int mark;

    public boolean isUnivalTree(final TreeNode root) {
        if (root == null) {
            return true;
        }
        mark = root.val;
        return dp(root);
    }

    private boolean dp(final TreeNode root) {
        if (root == null) {
            return true;
        }
        return root.val == mark && dp(root.left) && dp(root.right);
    }
}
