package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 617: Merge Two Binary Trees.
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(final TreeNode root1, final TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode();
        if (root1 == null) {
            root.left = mergeTrees(null, root2.left);
            root.right = mergeTrees(null, root2.right);
            root.val = root2.val;
        } else if (root2 == null) {
            root.left = mergeTrees(root1.left, null);
            root.right = mergeTrees(root1.right, null);
            root.val = root1.val;
        } else {
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
            root.val = root1.val + root2.val;
        }
        return root;
    }

    public TreeNode mergeTreesPlus(final TreeNode root1, final TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        root1.val = root1.val + root2.val;
        return root1;
    }
}
