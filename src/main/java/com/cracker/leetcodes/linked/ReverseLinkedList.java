package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 206: Reverse Linked List.
 */
public class ReverseLinkedList {

    public ListNode reverseList(final ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public class ListNode {

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
