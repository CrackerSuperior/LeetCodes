package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This is Leetcode number 987: Vertical Order Traversal of a Binary Tree.
 */
public class VerticalOrderTraversalOfABinaryTree {

    private final List<Triple> nodes = new ArrayList<>();
    
    public List<List<Integer>> verticalTraversal(final TreeNode root) {
        dp(root, 0, 0);
        nodes.sort((Triple a, Triple b) -> {
            if (a.row == b.row && a.col == b.col) {
                return a.node.val - b.node.val;
            }
            if (a.col == b.col) {
                return a.row - b.row;
            }
            return a.col - b.col;
        });
        LinkedList<List<Integer>> result = new LinkedList<>();
        int mark = Integer.MIN_VALUE;
        for (Triple node : nodes) {
            if (node.col != mark) {
                mark = node.col;
                result.addLast(new LinkedList<>());
            }
            result.getLast().add(node.node.val);
        }
        return result;
    }
    
    private void dp(final TreeNode root, final int row, final int col) {
        if (root == null) {
            return;
        }
        nodes.add(new Triple(root, row, col));
        dp(root.left, row + 1, col - 1);
        dp(root.right, row + 1, col + 1);
    }
    
    public static class Triple {
        
        private final TreeNode node;
        
        private final int row;
        
        private final int col;
        
        Triple(final TreeNode node, final int row, final int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
