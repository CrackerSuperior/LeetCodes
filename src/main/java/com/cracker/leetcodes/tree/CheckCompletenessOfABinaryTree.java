package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is Leetcode number 958: Check Completeness of a Binary Tree.
 */
public class CheckCompletenessOfABinaryTree {

    public boolean isCompleteTree(final TreeNode root) {
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root);
        boolean mark = false;
        while (!tree.isEmpty()) {
            int size = tree.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = tree.poll();
                if (null == node) {
                    mark = true;
                } else {
                    if (mark) {
                        return false;
                    }
                    tree.offer(node.left);
                    tree.offer(node.right);
                }
            }
        }
        return true;
    }
}
