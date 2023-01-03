package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

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
}
