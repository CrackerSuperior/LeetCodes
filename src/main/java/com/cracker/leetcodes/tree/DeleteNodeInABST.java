package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 450: Delete Node in a BST.
 */
public class DeleteNodeInABST {

    public TreeNode deleteNode(final TreeNode root, final int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode min = getMin(root.right);
            root.right = deleteNode(root.right, min.val);
            root.val = min.val;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(final TreeNode right) {
        TreeNode temp = right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
}
