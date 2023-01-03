package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

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
}
