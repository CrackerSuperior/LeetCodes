package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is Leetcode number 103: Binary Tree Zigzag Level Order Traversal.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(final TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root);
        boolean mark = true;
        while (!tree.isEmpty()) {
            int size = tree.size();
            LinkedList<Integer> subResult = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = tree.poll();
                if (mark) {
                    subResult.addLast(node.val);
                } else {
                    subResult.addFirst(node.val);
                }
                if (node.left != null) {
                    tree.offer(node.left);
                }
                if (node.right != null) {
                    tree.offer(node.right);
                }
            }
            mark = !mark;
            result.add(subResult);
        }
        return result;
    }
}
