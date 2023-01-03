package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This is Leetcode number 653: Two Sum IV - Input is a BST.
 */
public class TwoSumIVInputIsABST {

    private final Set<Integer> result = new HashSet<>();

    public boolean findTarget(final TreeNode root, final int k) {
        List<Integer> tree = dp(root);
        int i = 0;
        int j = tree.size() - 1;
        while (i < j) {
            int sum = tree.get(i) + tree.get(j);
            if (sum < k) {
                i++;
            } else if (sum > k) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    private List<Integer> dp(final TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> tree = new ArrayList<>(dp(root.left));
        tree.add(root.val);
        tree.addAll(dp(root.right));
        return tree;
    }

    public boolean findTargetPlus(final TreeNode root, final int k) {
        if (root == null) {
            return false;
        }
        if (result.contains(k - root.val)) {
            return true;
        }
        result.add(root.val);
        return findTargetPlus(root.left, k) || findTargetPlus(root.right, k);
    }
}
