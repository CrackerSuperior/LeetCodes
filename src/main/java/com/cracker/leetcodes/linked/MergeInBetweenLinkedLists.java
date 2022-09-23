package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 1669: Merge In Between Linked Lists.
 */
public class MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(final ListNode list1, final int a, final int b, final ListNode list2) {
        ListNode temp1 = list1.next;
        ListNode pre = list1;
        ListNode next = list1;
        int index = 0;
        while (temp1 != null) {
            if (index < a) {
                pre = pre.next;
            }
            if (index <= b) {
                next = next.next;
            }
            temp1 = temp1.next;
            index++;
        }
        ListNode temp2 = list2;
        pre.next = temp2;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = next.next;
        return list1;
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
