package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is Leetcode Offer 32 - I: Print Binary Tree from Top to Bottom.
 */
public class Offer32IPrintBinaryTreeFromTopToBottom {

    public int[] levelOrder(final TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        int[] result = new int[1000];
        int index = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            result[index++] = node.val;
            if (node.left != null) {
                nodes.offer(node.left);
            }
            if (node.right != null) {
                nodes.offer(node.right);
            }
        }
        return Arrays.copyOf(result, index);
    }
}
