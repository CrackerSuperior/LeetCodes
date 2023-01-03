package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 993: Cousins in Binary Tree.
 */
public class CousinsInBinaryTree {

    private TreeNode parentX;

    private TreeNode parentY;

    private int depthX;

    private int depthY;

    public boolean isCousins(final TreeNode root, final int x, final int y) {
        if (root == null) {
            return false;
        }
        parentX = parentY = null;
        depthX = depthY = 0;
        dp(root, 0, null, x, y);
        return depthX == depthY && parentX != parentY;
    }

    private void dp(final TreeNode root, final int depth, final TreeNode parent, final int x, final int y) {
        if (root == null) {
            return;
        }
        if (x == root.val) {
            parentX = parent;
            depthX = depth;
        }
        if (y == root.val) {
            parentY = parent;
            depthY = depth;
        }
        if (depthX == depthY && parentX != parentY) {
            return;
        }
        dp(root.left, depth + 1, root, x, y);
        dp(root.right, depth + 1, root, x, y);
    }
}
