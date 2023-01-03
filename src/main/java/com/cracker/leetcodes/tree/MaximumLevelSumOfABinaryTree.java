package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

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
}
