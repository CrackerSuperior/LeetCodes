package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 142: Linked List Cycle II.
 */
public class LinkedListCycleII {

    public ListNode detectCycle(final ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    static class ListNode {

        private int val;

        private ListNode next;

        ListNode(final int x) {
            val = x;
            next = null;
        }
    }
}
