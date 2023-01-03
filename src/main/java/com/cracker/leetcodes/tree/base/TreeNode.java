package com.cracker.leetcodes.tree.base;

public final class TreeNode {

    // CHECKSTYLE:OFF
    public int val;

    public TreeNode left;

    public TreeNode right;
    // CHECKSTYLE:ON

    public TreeNode() { }

    public TreeNode(final int val) {
        this.val = val;
    }

    public TreeNode(final int val, final TreeNode left, final TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
