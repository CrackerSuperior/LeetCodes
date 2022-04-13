package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 92: Reverse Linked List II.
 */
public class ReverseLinkedListII {

    private ListNode mark = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            mark = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = mark;
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
