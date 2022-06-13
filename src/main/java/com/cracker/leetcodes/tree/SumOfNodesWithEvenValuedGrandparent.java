package com.cracker.leetcodes.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 1315: Sum of Nodes with Even-Valued Grandparent.
 */
public class SumOfNodesWithEvenValuedGrandparent {

    private final Map<TreeNode, TreeNode> result = new HashMap<>();

    public int sumEvenGrandparent(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (result.isEmpty()) {
            dp(root, null);
        }
        int sum = 0;
        int val = getGrandfather(root);
        if (val != 0 && val % 2 == 0) {
            sum += root.val;
        }
        sum += sumEvenGrandparent(root.left);
        sum += sumEvenGrandparent(root.right);
        return sum;
    }

    private void dp(final TreeNode root, final TreeNode father) {
        if (root == null) {
            return;
        }
        result.put(root, father);
        dp(root.left, root);
        dp(root.right, root);
    }

    private int getGrandfather(final TreeNode root) {
        TreeNode node = result.get(result.get(root));
        if (null == node) {
            return 0;
        }
        return node.val;
    }

    public int sumEvenGrandparentPlus(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                sum = getSum(root.left.left, sum);
                sum = getSum(root.left.right, sum);
            }
            if (root.right != null) {
                sum = getSum(root.right.left, sum);
                sum = getSum(root.right.right, sum);
            }
        }
        sum += sumEvenGrandparentPlus(root.left);
        sum += sumEvenGrandparentPlus(root.right);
        return sum;
    }

    private int getSum(final TreeNode node, final int sum) {
        if (node != null) {
            return sum + node.val;
        }
        return sum;
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
