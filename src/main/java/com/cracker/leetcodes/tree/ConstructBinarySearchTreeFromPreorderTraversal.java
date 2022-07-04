package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 1008: Construct Binary Search Tree from Preorder Traversal.
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

    public TreeNode bstFromPreorder(final int[] preorder) {
        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(final int[] preorder, final int start, final int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int p = start + 1;
        while (p <= end && preorder[p] < root.val) {
            p++;
        }
        root.left = buildTree(preorder, start + 1, p - 1);
        root.right = buildTree(preorder, p, end);
        return root;
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
