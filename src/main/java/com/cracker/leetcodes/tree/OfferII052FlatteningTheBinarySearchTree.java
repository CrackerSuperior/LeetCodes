package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode Offer II 052: Flattening the binary search tree.
 *      This question is the same as leetcode's 897 questions.
 */
public class OfferII052FlatteningTheBinarySearchTree {

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
