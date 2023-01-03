package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is Leetcode number 1302: Deepest Leaves Sum.
 */
public class DeepestLeavesSum {

    private int maxDepth;

    private int result;

    public int deepestLeavesSum(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        int sum = 0;
        while (!treeNodes.isEmpty()) {
            sum = 0;
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodes.poll();
                sum += node.val;
                if (node.left != null) {
                    treeNodes.offer(node.left);
                }
                if (node.right != null) {
                    treeNodes.offer(node.right);
                }
            }
        }
        return sum;
    }

    public int deepestLeavesSumPlus(final TreeNode root) {
        dp(root, 0);
        return result;
    }
    
    private void dp(final TreeNode root, final int depth) {
        if (root == null) {
            return;
        }
        if (depth == maxDepth) {
            result += root.val;
        } else if (depth > maxDepth) {
            maxDepth = depth;
            result = root.val;
        }
        dp(root.left, depth + 1);
        dp(root.right, depth + 1);
    }
}
