package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 101: Symmetric Tree.
 */
public class SymmetricTree {

    public boolean isSymmetric(final TreeNode root) {
        return dp(root.left, root.right);
    }

    private boolean dp(final TreeNode p, final TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        return dp(p.left, q.right) && dp(p.right, q.left) && p.val == q.val;
    }
}
