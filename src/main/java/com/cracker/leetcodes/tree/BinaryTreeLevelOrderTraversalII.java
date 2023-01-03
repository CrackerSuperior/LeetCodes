package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is Leetcode number 107: Binary Tree Level Order Traversal II.
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(final TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root);
        while (!tree.isEmpty()) {
            int size = tree.size();
            List<Integer> subResult = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = tree.poll();
                subResult.add(node.val);
                if (node.left != null) {
                    tree.offer(node.left);
                }
                if (node.right != null) {
                    tree.offer(node.right);
                }
            }
            result.addFirst(subResult);
        }
        return result;
    }
}
