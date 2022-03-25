package com.cracker.leetcodes.linked;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This is Leetcode number 23: Merge k Sorted Lists.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(final ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> nodes = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                nodes.add(node);
            }
        }
        while (!nodes.isEmpty()) {
            ListNode minNode = nodes.poll();
            p.next = minNode;
            if (minNode.next != null) {
                nodes.add(minNode.next);
            }
            p = p.next;
        }
        return dummy.next;
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
