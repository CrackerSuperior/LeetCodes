package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 538: Convert BST to Greater Tree.
 */
public class ConvertBSTtoGreaterTree {

    private int sum;

    public TreeNode convertBST(final TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
