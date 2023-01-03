package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode Offer 054: The kth largest node of the binary search tree.
 */
public class OfferTheKthLargestNodeOfTheBinarySearchTree {

    private int num;

    private int result;

    public int kthLargest(final TreeNode root, final int k) {
        if (root == null) {
            return 0;
        }
        kthLargest(root.right, k);
        if (++num == k) {
            result = root.val;
        }
        kthLargest(root.left, k);
        return result;
    }
}
