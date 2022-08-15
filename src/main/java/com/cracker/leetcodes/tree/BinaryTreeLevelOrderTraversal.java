package com.cracker.leetcodes.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is Leetcode number 102: Binary Tree Level Order Traversal.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(final TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            List<Integer> subResult = new LinkedList<>();
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodes.poll();
                assert node != null;
                subResult.add(node.val);
                if (node.left != null) {
                    treeNodes.offer(node.left);
                }
                if (node.right != null) {
                    treeNodes.offer(node.right);
                }
            }
            result.add(subResult);
        }
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
