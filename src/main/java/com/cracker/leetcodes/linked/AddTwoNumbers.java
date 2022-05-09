package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 2: Add Two Numbers.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
        ListNode head = new ListNode(-1);
        head.next = dp(l1, l2, 0);
        return head.next;
    }

    private ListNode dp(final ListNode left, final ListNode right, final int number) {
        if (null == left && null == right) {
            if (number != 0) {
                return new ListNode(number);
            }
            return null;
        }
        int math;
        ListNode node = new ListNode();
        if (null == left) {
            math = number + right.val;
            node.val = math % 10;
            node.next = dp(null, right.next, math / 10);
            return node;
        }
        if (null == right) {
            math = number + left.val;
            node.val = math % 10;
            node.next = dp(left.next, null, math / 10);
            return node;
        }
        math = left.val + right.val + number;
        node.val = math % 10;
        node.next = dp(left.next, right.next, math / 10);
        return node;
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
