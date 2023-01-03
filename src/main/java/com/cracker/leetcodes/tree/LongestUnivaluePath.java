package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 687: Longest Univalue Path.
 */
public class LongestUnivaluePath {

    private int len;

    public int longestUnivaluePath(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        dp(root, root.val);
        return len;
    }

    private int dp(final TreeNode root, final int val) {
        if (root == null) {
            return 0;
        }
        int left = dp(root.left, root.val);
        int right = dp(root.right, root.val);
        len = Math.max(len, left + right);
        if (root.val != val) {
            return 0;
        }
        return 1 + Math.max(left, right);
    }
}
