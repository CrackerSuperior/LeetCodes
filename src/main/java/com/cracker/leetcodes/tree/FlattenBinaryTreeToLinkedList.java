package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 114: Flatten Binary Tree to Linked List.
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(final TreeNode root) {
        if (null == root) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (null != p.right) {
            p = p.right;
        }
        p.right = right;
    }
}
