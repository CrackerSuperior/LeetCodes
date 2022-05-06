package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 25: Reverse Nodes in k-Group.
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(final ListNode head, final int k) {
        if (null == head) {
            return null;
        }
        ListNode a;
        ListNode b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (null == b) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverse(final ListNode a, final ListNode b) {
        ListNode prev;
        ListNode next;
        ListNode current;
        prev = null;
        current = a;
        while (current != b) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    class ListNode {

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
}
