package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 129: Sum Root to Leaf Numbers.
 */
public class SumRootToLeafNumbers {

    private final StringBuilder path = new StringBuilder();

    private int result;

    public int sumNumbers(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        path.append(root.val);
        if (root.left == null && root.right == null) {
            result += Integer.parseInt(String.valueOf(path));
        }
        sumNumbers(root.left);
        sumNumbers(root.right);
        path.deleteCharAt(path.length() - 1);
        return result;
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
