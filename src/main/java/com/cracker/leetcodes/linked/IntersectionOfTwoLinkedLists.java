package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 160: Intersection of Two Linked Lists.
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
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
