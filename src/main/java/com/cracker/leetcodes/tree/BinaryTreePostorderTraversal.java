package com.cracker.leetcodes.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is Leetcode number 145: Binary Tree Postorder Traversal.
 */
public class BinaryTreePostorderTraversal {

    private final List<Integer> results = new ArrayList<>();

    public List<Integer> postorderTraversal(final TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        results.add(root.val);
        return results;
    }

    public static class TreeNode {

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
