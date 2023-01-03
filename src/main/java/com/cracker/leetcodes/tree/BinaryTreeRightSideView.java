package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Leetcode number 199: Binary Tree Right Side View.
 */
public class BinaryTreeRightSideView {
    
    private final List<Integer> result = new ArrayList<>();
    
    private int depth;

    public List<Integer> rightSideView(final TreeNode root) {
        dp(root);
        return result;
    }
    
    private void dp(final TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (result.size() < depth) {
            result.add(root.val);
        }
        dp(root.right);
        dp(root.left);
        depth--;
    }
}
