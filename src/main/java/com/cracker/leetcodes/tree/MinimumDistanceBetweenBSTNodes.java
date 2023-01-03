package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 783: Minimum Distance Between BST Nodes.
 *      This question is the same as leetcode's 530 question.
 */
public class MinimumDistanceBetweenBSTNodes {
    
    private int result = Integer.MAX_VALUE;
    
    private TreeNode prev;

    public int minDiffInBST(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDiffInBST(root.left);
        if (null != prev) {
            result = Math.min(result, Math.abs(root.val - prev.val));
        } 
        prev = root;
        minDiffInBST(root.right);
        return result;
    }
}
