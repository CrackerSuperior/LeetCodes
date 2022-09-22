package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 1290: Convert Binary Number in a Linked List to Integer.
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(final ListNode head) {
        int ans = 0;
        ListNode temp = head;
        while (temp != null) {
            ans = ans * 2 + temp.val;
            temp = temp.next;
        }
        return ans;
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
