package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 100: Same Tree.
 */
public class SameTree {

    public boolean isSameTree(final TreeNode p, final TreeNode q) {
        return dp(p, q);
    }

    private boolean dp(final TreeNode p, final TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        return dp(p.left, q.left) && dp(p.right, q.right) && p.val == q.val;
    }
}
