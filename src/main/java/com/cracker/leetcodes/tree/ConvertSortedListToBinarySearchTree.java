package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 109: Convert Sorted List to Binary Search Tree.
 */
public class ConvertSortedListToBinarySearchTree {

    private ListNode cur;

    public TreeNode sortedListToBST(final ListNode head) {
        ListNode first = head;
        int len = 0;
        while (null != first) {
            first = first.next;
            len++;
        }
        cur = head;
        return dp(0, len - 1);
    }

    private TreeNode dp(final int left, final int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode leftNode = dp(left, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode rightNode = dp(mid + 1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    static class ListNode {
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

    static class TreeNode {

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
