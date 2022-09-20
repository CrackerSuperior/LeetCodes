package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 2181: Merge Nodes in Between Zeros.
 */
public class MergeNodesInBetweenZeros {

    public ListNode mergeNodes(final ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (right.next != null) {
            if (right.val != 0) {
                left.val += right.val;
            } else {
                left = left.next;
                left.val = 0;
            }
            right = right.next;
        }
        left.next = null;
        return head;
    }

    static class ListNode {
        
        private int val;
        
        private ListNode next;

        ListNode() {
        }

        ListNode(final int val) {
            this.val = val;
        }

        ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
