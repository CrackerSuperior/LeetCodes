package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is Leetcode number 637: Average of Levels in Binary Tree.
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(final TreeNode root) {
        List<Double> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root);
        while (!tree.isEmpty()) {
            double subResult = 0;
            int size = tree.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = tree.poll();
                subResult += node.val;
                if (node.left != null) {
                    tree.offer(node.left);
                }
                if (node.right != null) {
                    tree.offer(node.right);
                }
            }
            results.add(subResult / size);
        }
        return results;
    }
}
