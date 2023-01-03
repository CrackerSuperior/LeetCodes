package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 988: Smallest String Starting From Leaf.
 */
public class SmallestStringStartingFromLeaf {

    private static final String[] TABLE = {
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
        "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
        "w", "x", "y", "z"};

    private String minStr = "{}";

    public String smallestFromLeaf(final TreeNode root) {
        if (root == null) {
            return "";
        }
        return dp(root, "");
    }

    private String dp(final TreeNode root, final String str) {
        if (root == null) {
            return str;
        }
        String tempStr = str + TABLE[root.val];
        if (root.left == null && root.right == null) {
            String string = new StringBuilder(tempStr).reverse().toString();
            minStr = minStr.compareTo(string) < 0 ? minStr : string;
            return minStr;
        }
        dp(root.left, tempStr);
        dp(root.right, tempStr);
        return minStr;
    }
}
