package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 2236: Root Equals Sum of Children.
 */
public class RootEqualsSumOfChildren {

    public boolean checkTree(final TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
