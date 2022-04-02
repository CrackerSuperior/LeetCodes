package com.cracker.leetcodes.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 106: Construct Binary Tree from Inorder and Postorder Traversal.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(final int[] inorder, final int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(map, 0,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(final Map<Integer, Integer> map, final int inoStart,
                           final int[] postorder, final int posStart, final int posEnd) {
        if (posStart > posEnd) {
            return null;
        }
        int rootVal = postorder[posEnd];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        int leftSize = index - inoStart;
        root.left = build(map, inoStart,
                postorder, posStart, posStart + leftSize - 1);
        root.right = build(map, index + 1,
                postorder, posStart + leftSize, posEnd - 1);
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
