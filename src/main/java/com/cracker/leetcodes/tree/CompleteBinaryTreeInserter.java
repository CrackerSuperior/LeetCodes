package com.cracker.leetcodes.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is Leetcode number 919: Complete Binary Tree Inserter.
 */
public class CompleteBinaryTreeInserter {

    class CBTInserter {
        
        private final TreeNode root;
        
        private Queue<TreeNode> bottom = new LinkedList<>();

        CBTInserter(final TreeNode root) {
            this.root = root;
            Queue<TreeNode> tree = new LinkedList<>();
            tree.offer(root);
            while (!tree.isEmpty()) {
                TreeNode temp = tree.poll();
                if (temp.left != null) {
                    tree.offer(temp.left);
                }
                if (temp.right != null) {
                    tree.offer(temp.right);
                }
                if (temp.left == null || temp.right == null) {
                    bottom.offer(temp);
                }
            }
        }

        public int insert(final int val) {
            TreeNode peek = bottom.peek();
            TreeNode node = new TreeNode(val);
            if (peek.left == null) {
                peek.left = node;
            } else if (peek.right == null) {
                peek.right = node;
                bottom.poll();
            }
            bottom.offer(node);
            return peek.val;
        }

        public TreeNode getRoot() {
            return root;
        }
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
