package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 1448: Count Good Nodes in Binary Tree.
 */
public class CountGoodNodesInBinaryTree {

    private int result;

    private int max;

    public int goodNodes(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = root.val;
        dp(root);
        return result;
    }

    private void dp(final TreeNode root) {
        if (root == null) {
            return;
        }
        final int temp = max;
        if (max <= root.val) {
            max = root.val;
            result++;
        }
        dp(root.left);
        dp(root.right);
        max = temp;
    }

    public int goodNodesPlus(final TreeNode root) {
        dpPlus(root, root.val);
        return result;
    }

    private void dpPlus(final TreeNode root, final int pathMax) {
        if (root == null) {
            return;
        }
        if (pathMax <= root.val) {
            result++;
        }
        int tempMax = Math.max(pathMax, root.val);
        dpPlus(root.left, tempMax);
        dpPlus(root.right, tempMax);
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
