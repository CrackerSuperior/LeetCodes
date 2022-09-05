package com.cracker.leetcodes.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is Leetcode number 515: Find The Largest Value in Each Tree Row.
 */
public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(final TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root);
        while (!tree.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = tree.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = tree.poll();
                if (max < node.val) {
                    max = node.val;
                }
                if (node.left != null) {
                    tree.offer(node.left);
                }
                if (node.right != null) {
                    tree.offer(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }

    public List<Integer> largestValuesPlus(final TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        dp(root, result, 0);
        return result;
    }

    private void dp(final TreeNode root, final List<Integer> result, final int level) {
        if (null == root) {
            return;
        }
        if (level == result.size()) {
            result.add(root.val);
        } else {
            result.set(level, Math.max(result.get(level), root.val));
        }
        dp(root.left, result, level + 1);
        dp(root.right, result, level + 1);
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
