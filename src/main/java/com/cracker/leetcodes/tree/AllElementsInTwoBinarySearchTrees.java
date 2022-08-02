package com.cracker.leetcodes.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * This is Leetcode number 1305: All Elements in Two Binary Search Trees.
 */
public class AllElementsInTwoBinarySearchTrees {
    
    private final List<Integer> result = new LinkedList<>();

    public List<Integer> getAllElements(final TreeNode root1, final TreeNode root2) {
        BSTIterator iterator1 = new BSTIterator(root1);
        BSTIterator iterator2 = new BSTIterator(root2);
        while (iterator1.hasNext() && iterator2.hasNext()) {
            
            if (iterator1.peek() <= iterator2.peek()) {
                result.add(iterator1.next());
            } else {
                result.add(iterator2.next());
            }
        }
        while (iterator1.hasNext()) {
            result.add(iterator1.next());
        }
        while (iterator2.hasNext()) {
            result.add(iterator2.next());
        }
        return result;
    }

    public static class BSTIterator {
        
        private final Deque<TreeNode> stack = new ArrayDeque<>();
        
        BSTIterator(final TreeNode root) {
            build(root);
        }
        
        private void build(final TreeNode root) {
            TreeNode p = root;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        public Integer next() {
            TreeNode node = stack.pop();
            build(node.right);
            return node.val;
        }
        
        public Integer peek() {
            if (!stack.isEmpty()) {
                return stack.peek().val;
            } else {
                throw new NullPointerException();
            }
        }
    }

    public static class TreeNode {

        private int val;

        private TreeNode left;

        private TreeNode right;

        TreeNode() { }

        TreeNode(final int val) {
            this.val = val;
        }

        TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
