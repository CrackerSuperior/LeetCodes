package com.cracker.leetcodes.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This is Leetcode number 1110: Delete Nodes And Return Forest.
 */
public class DeleteNodesAndReturnForest {

    private final List<TreeNode> results = new ArrayList<>();

    public List<TreeNode> delNodes(final TreeNode root, final int[] toDelete) {
        Set<Integer> set = new HashSet<>();
        for (int i : toDelete) {
            set.add(i);
        }
        dp(root, set, false);
        return results;
    }

    private TreeNode dp(final TreeNode root, final Set<Integer> set, final boolean hasFather) {
        if (root == null) {
            return null;
        }
        boolean delete = set.contains(root.val);
        if (!delete && !hasFather) {
            results.add(root);
        }
        root.left = dp(root.left, set, !delete);
        root.right = dp(root.right, set, !delete);
        return delete ? null : root;
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
