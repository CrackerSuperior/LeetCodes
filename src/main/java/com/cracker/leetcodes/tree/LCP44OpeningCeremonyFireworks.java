package com.cracker.leetcodes.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * This is Leetcode LCP 44: Opening Ceremony Fireworks.
 */
public class LCP44OpeningCeremonyFireworks {

    private final Set<Integer> result = new HashSet<>();

    public int numColor(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        result.add(root.val);
        numColor(root.left);
        numColor(root.right);
        return result.size();
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
