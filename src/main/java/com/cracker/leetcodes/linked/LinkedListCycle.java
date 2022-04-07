package com.cracker.leetcodes.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 141: Linked List Cycle.
 */
public class LinkedListCycle {

    public boolean hasCycle(final ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }
            map.put(temp, 0);
            temp = temp.next;
        }
        return false;
    }

    public boolean hasCyclePlus(final ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    class ListNode {
        private int val;

        private ListNode next;

        ListNode(final int x) {
            val = x;
            next = null;
        }
    }
}
