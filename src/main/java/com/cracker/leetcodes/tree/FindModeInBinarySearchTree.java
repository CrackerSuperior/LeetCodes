package com.cracker.leetcodes.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Leetcode number 501: Find Mode in Binary Search Tree.
 */
public class FindModeInBinarySearchTree {

    private TreeNode prev;
    
    private int curCount;

    private int maxCount;

    public int[] findMode(final TreeNode root) {
        List<Integer> mode = new ArrayList<>();
        prev = null;
        dp(root, mode);
        int[] result = new int[mode.size()];
        for (int i = 0; i < mode.size(); i++) {
            result[i] = mode.get(i);
        }
        return result;
    }

    private void dp(final TreeNode root, final List<Integer> mode) {
        if (root == null) {
            return;
        }
        dp(root.left, mode);
        if (prev == null) {
            curCount = 1;
            maxCount = 1;
            mode.add(root.val);
        } else {
            ifEqual(root, mode);
            ifNoEqual(root, mode);
        }
        prev = root;
        dp(root.right, mode);
    }

    private void ifNoEqual(final TreeNode root, final List<Integer> mode) {
        if (root.val != prev.val) {
            curCount = 1;
            if (curCount == maxCount) {
                mode.add(root.val);
            }
        }
    }

    private void ifEqual(final TreeNode root, final List<Integer> mode) {
        if (root.val == prev.val) {
            curCount++;
            if (curCount == maxCount) {
                mode.add(root.val);
            } else if (curCount > maxCount) {
                maxCount = curCount;
                mode.clear();
                mode.add(root.val);
            }
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
