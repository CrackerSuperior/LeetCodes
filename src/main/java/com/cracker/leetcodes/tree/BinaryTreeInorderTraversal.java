package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Leetcode number 94: Binary Tree Inorder Traversal.
 */

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(final TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dp(root, result);
        return result;
    }

    private void dp(final TreeNode root, final List<Integer> result) {
        if (root == null) {
            return;
        }
        dp(root.left, result);
        result.add(root.val);
        dp(root.right, result);
    }
}
