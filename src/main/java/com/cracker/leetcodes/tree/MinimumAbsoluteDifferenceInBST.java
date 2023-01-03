package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 530: Minimum Absolute Difference in BST.
 */
public class MinimumAbsoluteDifferenceInBST {

    private final int[] min = {Integer.MAX_VALUE};

    private final int[] prev = {-1};

    public int getMinimumDifference(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinimumDifference(root.left);
        if (prev[0] != -1) {
            int abs = Math.abs(root.val - prev[0]);
            min[0] = Math.min(min[0], abs);
        }
        prev[0] = root.val;
        getMinimumDifference(root.right);
        return min[0];
    }
}
