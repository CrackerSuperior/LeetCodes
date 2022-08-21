package com.cracker.leetcodes.tree;

/**
 * This is Leetcode number 1123: Lowest Common Ancestor of The Deepest Leaves.
 *      This question is the same as leetcode's 865 questions.
 */
public class LowestCommonAncestorOfDeepestLeaves {
    
    public TreeNode lcaDeepestLeaves(final TreeNode root) {
        Result result = dp(root);
        return result.node;
    }
    
    private Result dp(final TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }
        Result left = dp(root.left);
        Result right = dp(root.right);
        if (left.depth == right.depth) {
            return new Result(root, left.depth + 1);
        }
        Result result = left.depth > right.depth ? left : right;
        result.depth++;
        return result;
    }
    
    public static class Result {
        
        private final TreeNode node;
        
        private int depth;
        
        Result(final TreeNode node, final int depth) {
            this.node = node;
            this.depth = depth;
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
