package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 234: Palindrome Linked List.
 */
public class PalindromeLinkedList {

    private ListNode left;

    public boolean isPalindrome(final ListNode head) {
        left = head;
        return dp(head);
    }

    private boolean dp(final ListNode right) {
        if (null == right) {
            return true;
        }
        boolean res = dp(right.next);
        res = res && (left.val == right.val);
        left = left.next;
        return res;
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
