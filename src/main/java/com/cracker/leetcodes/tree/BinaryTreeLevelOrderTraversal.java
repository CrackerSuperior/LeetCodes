package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

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
}
