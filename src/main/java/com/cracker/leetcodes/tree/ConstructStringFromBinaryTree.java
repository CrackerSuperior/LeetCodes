package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 606: Construct String from Binary Tree.
 */
public class ConstructStringFromBinaryTree {

    private final StringBuilder result = new StringBuilder();

    public String tree2str(final TreeNode root) {
        dp(root);
        return result.toString();
    }

    private void dp(final TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.append(root.val);
        } else {
            result.append(root.val);
            result.append("(");
            if (root.left != null) {
                dp(root.left);
            }
            result.append(")");
            if (root.right != null) {
                result.append("(");
                dp(root.right);
                result.append(")");
            }
        }
    }
}
