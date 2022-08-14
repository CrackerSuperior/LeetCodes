package com.cracker.leetcodes.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This is Leetcode Offer II 046: The right side view of the binary tree.
 *      This question is the same as leetcode's 199 questions.
 */
public class OfferII046TheRightSideViewOfTheBinaryTree {
    
    private final List<Integer> result = new LinkedList<>();
    
    private int depth;
    
    private int maxDepth;

    public List<Integer> rightSideView(final TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        depth++;
        if (maxDepth < depth) {
            result.add(root.val);
            maxDepth = depth;
        }
        rightSideView(root.right);
        rightSideView(root.left);
        depth--;
        return result;
    }

    public List<Integer> rightSideViewPlus(final TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        depth++;
        if (result.size() < depth) {
            result.add(root.val);
        }
        rightSideView(root.right);
        rightSideView(root.left);
        depth--;
        return result;
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
