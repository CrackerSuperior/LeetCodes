package com.cracker.leetcodes.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is Leetcode number 95: Unique Binary Search Trees II.
 */
public class UniqueBinarySearchTreesII {

    private List<TreeNode>[][] results;

    public List<TreeNode> generateTrees(final int n) {
        results = new ArrayList[n + 1][n + 1];
        if (n == 0) {
            return Collections.emptyList();
        }
        return build(1, n);
    }

    private List<TreeNode> build(final int leftIndex, final int rightIndex) {
        List<TreeNode> result = new ArrayList<>();
        if (leftIndex > rightIndex) {
            result.add(null);
            return result;
        }
        if (results[leftIndex][rightIndex] != null) {
            return results[leftIndex][rightIndex];
        }
        for (int mid = leftIndex; mid <= rightIndex; mid++) {
            List<TreeNode> left = build(leftIndex, mid - 1);
            List<TreeNode> right = build(mid + 1, rightIndex);
            for (TreeNode leftChild : left) {
                for (TreeNode rightChild : right) {
                    TreeNode root = new TreeNode(mid);
                    root.left = leftChild;
                    root.right = rightChild;
                    result.add(root);
                }
            }
        }
        results[leftIndex][rightIndex] = result;
        return result;
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
