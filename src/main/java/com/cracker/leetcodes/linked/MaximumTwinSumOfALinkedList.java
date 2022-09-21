package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 2130: Maximum Twin Sum of a Linked List.
 */
public class MaximumTwinSumOfALinkedList {

    public int pairSum(final ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        ListNode reverse = low.next;
        low.next = null;
        ListNode prev = null;
        while (reverse != null) {
            ListNode temp = reverse.next;
            reverse.next = prev;
            prev = reverse;
            reverse = temp;
        }
        int max = Integer.MIN_VALUE;
        ListNode old = head;
        while (prev != null) {
            max = Math.max(max, old.val + prev.val);
            prev = prev.next;
            old = old.next;
        }
        return max;
    }

    public int pairSumPlus(final ListNode head) {
        ListNode fast = head.next;
        ListNode low = head;
        ListNode mid = low.next;
        ListNode prev = null;
        while (fast.next != null) {
            ListNode temp = low.next;
            low.next = prev;
            prev = low;
            low = temp;
            mid = low.next;
            fast = fast.next.next;
        }
        low.next = prev;
        int max = Integer.MIN_VALUE;
        while (low != null) {
            max = Math.max(max, low.val + mid.val);
            low = low.next;
            mid = mid.next;
        }
        return max;
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
