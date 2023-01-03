package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 513: Find Bottom Left Tree Value.
 */
public class FindBottomLeftTreeValue {

    private int maxDepth;
    
    private int depth;

    private int result;
    
    public int findBottomLeftValue(final TreeNode root) {
        dp(root);
        return result;
    }

    private void dp(final TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (depth > maxDepth) {
            maxDepth = depth;
            result = root.val;
        }
        dp(root.left);
        dp(root.right);
        depth--;
    }
}
