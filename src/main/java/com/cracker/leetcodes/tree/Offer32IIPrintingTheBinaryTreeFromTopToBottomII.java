package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is Leetcode Offer 32 - II: Printing the binary tree from top to bottom II.
 *      This question is the same as leetcode's 102 questions.
 */
public class Offer32IIPrintingTheBinaryTreeFromTopToBottomII {

    public List<List<Integer>> levelOrder(final TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root);
        while (!tree.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            int size = tree.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = tree.poll();
                levelNodes.add(node.val);
                if (node.left != null) {
                    tree.offer(node.left);
                }
                if (node.right != null) {
                    tree.offer(node.right);
                }
            }
            result.add(levelNodes);
        }
        return result;
    }
}
