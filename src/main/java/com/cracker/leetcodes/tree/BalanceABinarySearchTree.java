package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Leetcode number 1382: Balance a Binary Search Tree.
 */
public class BalanceABinarySearchTree {

    public TreeNode balanceBST(final TreeNode root) {
        List<Integer> tree = dp(root);
        return build(tree, 0, tree.size() - 1);
    }
    
    private List<Integer> dp(final TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        if (root == null) {
            return tree;
        }
        tree.addAll(dp(root.left));
        tree.add(root.val);
        tree.addAll(dp(root.right));
        return tree;
    }
    
    private TreeNode build(final List<Integer> tree, final int left, final int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(tree.get(mid));
        root.left = build(tree, left, mid - 1);
        root.right = build(tree, mid + 1, right);
        return root;
    }
}
