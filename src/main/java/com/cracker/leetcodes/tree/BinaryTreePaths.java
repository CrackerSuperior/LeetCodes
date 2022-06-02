package com.cracker.leetcodes.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Leetcode number 257: Binary Tree Paths.
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(final TreeNode root) {
        List<String> paths = new ArrayList<>();
        dp(root, "", paths);
        return paths;
    }

    private void dp(final TreeNode root, final String path, final List<String> paths) {
        if (root != null) {
            StringBuilder buildPath = new StringBuilder(path);
            buildPath.append(root.val);
            if (root.left == null && root.right == null) {
                paths.add(buildPath.toString());
            } else {
                buildPath.append("->");
                dp(root.left, buildPath.toString(), paths);
                dp(root.right, buildPath.toString(), paths);
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
