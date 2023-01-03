package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode number 951: Flip Equivalent Binary Trees.
 */
public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(final TreeNode root1, final TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
