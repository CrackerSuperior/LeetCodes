package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 99: Recover Binary Search Tree.
 */
public class RecoverBinarySearchTree {

    private TreeNode first;
    
    private TreeNode second;
    
    private TreeNode min = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(final TreeNode root) {
        dp(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void dp(final TreeNode root) {
        if (root == null) {
            return;
        }
        dp(root.left);
        if (root.val < min.val) {
            if (first == null) {
                first = min;
            } 
            second = root;
        }
        min = root;
        dp(root.right);
    }
}
