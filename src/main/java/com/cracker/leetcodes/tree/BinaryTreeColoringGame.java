package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 1145: Binary Tree Coloring Game.
 */
public class BinaryTreeColoringGame {
    
    private int left;
    
    private int right;
    
    public boolean btreeGameWinningMove(final TreeNode root, final int n, final int x) {
        dp(root, x);
        return left * 2 > n || right * 2 > n || (n - left - right - 1) * 2 > n;
    }
    
    private int dp(final TreeNode root, final int x) {
        if (root == null) {
            return 0;
        }
        int leftTemp = dp(root.left, x);
        int rightTemp = dp(root.right, x);
        if (root.val == x) {
            left = leftTemp;
            right = rightTemp;
            return -1;
        }
        return leftTemp + rightTemp + 1;
    }
}
