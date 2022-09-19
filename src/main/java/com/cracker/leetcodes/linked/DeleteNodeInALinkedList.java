package com.cracker.leetcodes.linked;

/**
 * This is Leetcode number 237: Delete Node in a Linked List.
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(final ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
    static class ListNode {
        
        private int val;
        
        private ListNode next;
        
        ListNode(final int x) {
            val = x;
        }
    }
}
