package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 1038: Binary Search Tree to Greater Sum Tree.
 *      This question is the same as leetcode's 538 questions.
 */
public class BinarySearchTreeToGreaterSumTree {

    private int sum;

    public TreeNode bstToGst(final TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }
}
