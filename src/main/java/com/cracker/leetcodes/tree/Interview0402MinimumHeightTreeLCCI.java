package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode Interview questions 04.02: Minimum Height Tree LCCI.
 */
public class Interview0402MinimumHeightTreeLCCI {

    public TreeNode sortedArrayToBST(final int[] nums) {
        return dp(nums, 0, nums.length - 1);
    }

    private TreeNode dp(final int[] nums, final int left, final int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dp(nums, left, mid - 1);
        root.right = dp(nums, mid + 1, right);
        return root;
    }
}
