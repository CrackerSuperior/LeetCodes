package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 230: Kth Smallest Element in a BST.
 */
public class KthSmallestElementInABST {

    private int result;

    private int rank;

    public int kthSmallest(final TreeNode root, final int k) {
        dp(root, k);
        return result;
    }

    private void dp(final TreeNode root, final int k) {
        if (root == null) {
            return;
        }
        dp(root.left, k);
        if (++rank == k) {
            result = root.val;
            return;
        }
        dp(root.right, k);
    }
}
