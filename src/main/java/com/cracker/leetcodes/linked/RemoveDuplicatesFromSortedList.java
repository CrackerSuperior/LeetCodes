package com.cracker.leetcodes.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 83: Remove Duplicates from Sorted List.
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(final ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode node = new ListNode(temp.val);
        map.put(temp.val, node);
        ListNode result = node;
        while (temp != null) {
            if (!map.containsKey(temp.val)) {
                node.next = new ListNode(temp.val);
                map.put(temp.val, node);
                node = node.next;
            }
            temp = temp.next;
        }
        return result;
    }

    public ListNode deleteDuplicatesPlus(final ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
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
