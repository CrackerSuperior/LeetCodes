package com.cracker.leetcodes.linked;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * This is Leetcode number 21: Merge Two Sorted Lists.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(final ListNode list1, final ListNode list2) {
        ListNode first = list1;
        ListNode second = list2;
        ArrayList<Integer> arr = new ArrayList<>();
        while (first != null) {
            arr.add(first.val);
            first = first.next;
        }
        while (second != null) {
            arr.add(second.val);
            second = second.next;
        }
        if (arr.isEmpty()) {
            return null;
        }
        arr = (ArrayList<Integer>) arr.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        ListNode[] listNode = {new ListNode(arr.get(0))};
        arr.stream().skip(1).forEach(each -> listNode[0] = new ListNode(each, listNode[0]));
        return listNode[0];
    }

    public ListNode mergeTwoListsPlus(final ListNode list1, final ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode p = result;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return result.next;
    }

    public static class ListNode {
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
