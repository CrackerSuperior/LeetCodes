package com.cracker.leetcodes.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is Leetcode number 1609: Even Odd Tree.
 */
public class EvenOddTree {

    public boolean isEvenOddTree(final TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root);
        boolean even = true;
        while (!tree.isEmpty()) {
            int size = tree.size();
            int pre = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = tree.poll();
                if (even) {
                    if (pre >= node.val || node.val % 2 == 0) {
                        return false;
                    }
                } else {
                    if (pre <= node.val || node.val % 2 == 1) {
                        return false;
                    }
                }
                pre = node.val;
                if (node.left != null) {
                    tree.offer(node.left);
                }
                if (node.right != null) {
                    tree.offer(node.right);
                }
            }
            even = !even;
        }
        return true;
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
