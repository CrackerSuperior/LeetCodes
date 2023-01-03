package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 998: Maximum Binary Tree II.
 */
public class MaximumBinaryTreeII {

    public TreeNode insertIntoMaxTree(final TreeNode root, final int val) {
        return build(root, val);
    }

    private TreeNode build(final TreeNode root, final int val) {
        TreeNode node = root;
        if (node == null) {
            return new TreeNode(val);
        }
        if (node.val < val) {
            TreeNode temp = node;
            node = new TreeNode(val);
            node.left = temp;
        } else {
            node.right = build(node.right, val);
        }
        return node;
    }
}
