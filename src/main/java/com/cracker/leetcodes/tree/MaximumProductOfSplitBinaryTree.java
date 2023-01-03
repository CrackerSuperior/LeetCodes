package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 1339: Maximum Product of Splitted Binary Tree.
 */
public class MaximumProductOfSplitBinaryTree {

    private int treeSum;

    private long result;

    public int maxProduct(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        treeSum = getSum(root);
        getSum(root);
        return (int) (result % (10e9 + 7));
    }

    private int getSum(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getSum(root.left);
        int right = getSum(root.right);
        int rootSum = left + right + root.val;
        result = Math.max(result, (long) rootSum * (treeSum - rootSum));
        return rootSum;
    }
}
