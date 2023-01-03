package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 701: Insert into a Binary Search Tree.
 */
public class InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(final TreeNode root, final int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
