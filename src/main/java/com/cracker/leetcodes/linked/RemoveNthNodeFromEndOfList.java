package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 19: Remove Nth Node From End of List.
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(final ListNode head, final int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int i = 0;
        while (fast.next != null) {
            if (i >= n) {
                slow = slow.next;
            }
            fast = fast.next;
            i++;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
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
}
