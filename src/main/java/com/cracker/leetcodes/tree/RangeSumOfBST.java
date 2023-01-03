package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 938: Range Sum of BST.
 */
public class RangeSumOfBST {

    public int rangeSumBST(final TreeNode root, final int low, final int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
