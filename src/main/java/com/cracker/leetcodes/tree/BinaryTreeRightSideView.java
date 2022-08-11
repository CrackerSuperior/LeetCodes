package com.cracker.leetcodes.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Leetcode number 199: Binary Tree Right Side View.
 */
public class BinaryTreeRightSideView {
    
    private final List<Integer> result = new ArrayList<>();
    
    private int depth;

    public List<Integer> rightSideView(final TreeNode root) {
        dp(root);
        return result;
    }
    
    private void dp(final TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (result.size() < depth) {
            result.add(root.val);
        }
        dp(root.right);
        dp(root.left);
        depth--;
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
