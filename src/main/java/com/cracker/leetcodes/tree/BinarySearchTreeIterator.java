package com.cracker.leetcodes.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This is Leetcode number 173: Binary Search Tree Iterator.
 */
public class BinarySearchTreeIterator {

    static class BSTIterator {
        
        private final Deque<TreeNode> stack = new ArrayDeque<>();

        BSTIterator(final TreeNode root) {
            build(root);
        }
        
        private void build(final TreeNode root) {
            TreeNode node = root;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            build(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
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
