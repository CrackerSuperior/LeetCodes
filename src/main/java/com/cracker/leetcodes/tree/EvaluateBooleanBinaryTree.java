package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 2331: Evaluate Boolean Binary Tree.
 */
public class EvaluateBooleanBinaryTree {

    public boolean evaluateTree(final TreeNode root) {
        if (root.left == null || root.right == null) {
            return root.val == 1;
        }
        return root.val == 2 
            ? evaluateTree(root.left) || evaluateTree(root.right) 
            : evaluateTree(root.left) && evaluateTree(root.right);
    }
}
