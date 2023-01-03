package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 654: Maximum Binary Tree.
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(final int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(final int[] nums, final int lo, final int hi) {
        if (lo > hi) {
            return null;
        }
        int index = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode temp = new TreeNode(maxVal);
        temp.left = build(nums, lo, index - 1);
        temp.right = build(nums, index + 1, hi);
        return temp;
    }
}
