package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 2265: Count Nodes Equal to Average of Subtree.
 */
public class CountNodesEqualToAverageOfSubtree {

    private int result;
    
    public int averageOfSubtree(final TreeNode root) {
        dp(root);
        return result;
    }
    
    private int[] dp(final TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int sum = left[0] + right[0] + root.val;
        int num = left[1] + right[1] + 1;
        if (sum / num == root.val) {
            result++;
        }
        return new int[] {sum, num};
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
