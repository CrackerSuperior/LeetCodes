package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 1379: Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
 */
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    private TreeNode result;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || result != null) {
            return null;
        }
        if (original == target) {
            result = cloned;
            return result;
        }
        getTargetCopy(original.left, cloned.left, target);
        getTargetCopy(original.right, cloned.right, target);
        return result;
    }
}
