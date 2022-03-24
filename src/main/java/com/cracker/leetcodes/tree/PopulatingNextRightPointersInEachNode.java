package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 116: Populating Next Right Pointers in Each Node.
 */
public class PopulatingNextRightPointersInEachNode {

    public Node connect(final Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    public Node connectPlus(final Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
            connectPlus(root.left);
            connectPlus(root.right);
        }
        return root;
    }

    public void connectTwoNode(final Node left, final Node right) {
        if (left == null) {
            return;
        }
        left.next = right;
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        connectTwoNode(left.right, right.left);
    }

    class Node {

        private int val;

        private Node left;

        private Node right;

        private Node next;

        Node() {

        }

        Node(final int val) {
            this.val = val;
        }

        Node(final int val, final Node left, final Node right, final Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
