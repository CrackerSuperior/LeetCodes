package com.cracker.leetcodes.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is Leetcode number 1161: Maximum Level Sum of a Binary Tree.
 */
public class MaximumLevelSumOfABinaryTree {

    public int maxLevelSum(final TreeNode root) {
        Queue<TreeNode> tree = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        tree.offer(root);
        int max = Integer.MIN_VALUE;
        int maxLevel = 0;
        int level = 0;
        while (!tree.isEmpty()) {
            int size = tree.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = tree.poll();
                sum += node.val;
                if (node.left != null) {
                    tree.offer(node.left);
                }
                if (node.right != null) {
                    tree.offer(node.right);
                }
            }
            level++;
            if (max < sum) {
                max = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
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
