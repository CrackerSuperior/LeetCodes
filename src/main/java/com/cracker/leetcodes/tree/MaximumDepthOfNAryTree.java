package com.cracker.leetcodes.tree;

import java.util.List;

/**
 * This is Leetcode number 559: Maximum Depth of N-ary Tree.
 */
public class MaximumDepthOfNAryTree {

    private int maxDepth;

    public int maxDepth(final Node root) {
        if (root == null) {
            return 0;
        }
        dp(root, 1);
        return maxDepth;
    }

    private void dp(final Node root, final int depth) {
        if (root == null) {
            return;
        }
        maxDepth = Math.max(depth, maxDepth);
        root.children.forEach(each -> dp(each, depth + 1));
    }

    public int maxDepthPlus(final Node root) {
        if (root == null) {
            return 0;
        }
        int[] tempMaxDepth = {0};
        root.children.forEach(each -> tempMaxDepth[0] = Math.max(tempMaxDepth[0], maxDepthPlus(each)));
        return 1 + tempMaxDepth[0];
    }

    static class Node {

        private int val;

        private List<Node> children;

        Node() { }

        Node(final int val) {
            this.val = val;
        }

        Node(final int val, final List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
