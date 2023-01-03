package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is Leetcode number 145: Binary Tree Postorder Traversal.
 */
public class BinaryTreePostorderTraversal {

    private final List<Integer> results = new ArrayList<>();

    public List<Integer> postorderTraversal(final TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        results.add(root.val);
        return results;
    }
}
