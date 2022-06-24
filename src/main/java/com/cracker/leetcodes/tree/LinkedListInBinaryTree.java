package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 1367: Linked List in Binary Tree.
 */
public class LinkedListInBinaryTree {

    public boolean isSubPath(final ListNode head, final TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val == head.val) {
            if (check(root, head)) {
                return true;
            }
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean check(final TreeNode root, final ListNode head) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val == head.val) {
            return check(root.left, head.next) || check(root.right, head.next);
        }
        return false;
    }

    public static class ListNode {

        private int val;

        private ListNode next;

        ListNode() { }

        ListNode(final int val) {
            this.val = val;
        }

        ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
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
