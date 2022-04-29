package com.cracker.leetcodes.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Leetcode number 94: Binary Tree Inorder Traversal.
 */

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(final TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dp(root, result);
        return result;
    }

    private void dp(final TreeNode root, final List<Integer> result) {
        if (root == null) {
            return;
        }
        dp(root.left, result);
        result.add(root.val);
        dp(root.right, result);
    }

    public class TreeNode {

        private int val;

        private TreeNode left;

        private TreeNode right;

        TreeNode() { }

        TreeNode(final int val) {
            this.val = val;
        }

        TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
