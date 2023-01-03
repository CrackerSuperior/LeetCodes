package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode Offer 68 - I: Nearest Common Ancestor of Binary Search Trees.
 *      This question is the same as leetcode's 235 questions.
 */
public class Offer68INearestCommonAncestorOfBinarySearchTrees {

    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        if (p.val >= root.val && q.val <= root.val) {
            return root;
        }
        if (p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
