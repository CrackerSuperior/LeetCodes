package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 700: Search in a Binary Search Tree.
 */
public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(final TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = increasingBST(root.left);
        root.left = null;
        root.right = increasingBST(root.right);
        if (left == null) {
            return root;
        }
        TreeNode node = left;
        while (node.right != null) {
            node = node.right;
        }
        node.right = root;
        return left;
    }
}
