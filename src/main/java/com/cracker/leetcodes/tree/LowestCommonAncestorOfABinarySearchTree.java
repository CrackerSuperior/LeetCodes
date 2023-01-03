package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 235: Lowest Common Ancestor of a Binary Search Tree.
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        if (p.val <= root.val && q.val >= root.val) {
            return root;
        }
        if (q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
