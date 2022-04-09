package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 876: Middle of the Linked List.
 */
public class MiddleOfTheLinkedList {

    public ListNode middleNode(final ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
