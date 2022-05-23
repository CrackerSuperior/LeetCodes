package com.cracker.leetcodes.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * This is Leetcode number 1261: Find Elements in a Contaminated Binary Tree.
 */
public class FindElementsInAContaminatedBinaryTree {

    class FindElements {

        private Set<Integer> result = new HashSet<>();

        FindElements(final TreeNode root) {
            dp(root, 0);
        }

        private void dp(final TreeNode root, final int x) {
            if (root == null) {
                return;
            }
            root.val = x;
            result.add(x);
            dp(root.left, (x << 1) + 1);
            dp(root.right, (x << 1) + 2);
        }

        public boolean find(final int target) {
            return result.contains(target);
        }
    }

    class TreeNode {

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
