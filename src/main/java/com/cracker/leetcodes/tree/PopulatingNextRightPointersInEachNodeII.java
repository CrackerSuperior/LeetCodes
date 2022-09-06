package com.cracker.leetcodes.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is Leetcode number 117: Populating Next Right Pointers in Each Node II.
 */
public class PopulatingNextRightPointersInEachNodeII {

    public Node connect(final Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> tree = new LinkedList<>();
        tree.offer(root);
        while (!tree.isEmpty()) {
            int size = tree.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = tree.poll();
                if (pre != null) {
                    pre.next = node;
                }
                pre = node;
                if (node.left != null) {
                    tree.offer(node.left);
                }
                if (node.right != null) {
                    tree.offer(node.right);
                }
            }
        }
        return root;
    }

    public static class Node {
        
        private int val;
        
        private Node left;
        
        private Node right;
        
        private Node next;

        public Node() { }

        public Node(final int val) {
            this.val = val;
        }

        public Node(final int val, final Node left, final Node right, final Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
