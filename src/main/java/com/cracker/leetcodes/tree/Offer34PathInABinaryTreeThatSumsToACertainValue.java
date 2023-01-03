package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This is Leetcode Offer 34: A path in a binary tree that sums to a certain value.
 *      This question is the same as leetcode's 113 questions.
 */
public class Offer34PathInABinaryTreeThatSumsToACertainValue {

    private final LinkedList<Integer> path = new LinkedList<>();

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(final TreeNode root, final int target) {
        if (root == null) {
            return Collections.emptyList();
        }
        dp(root, target);
        return result;
    }

    private void dp(final TreeNode root, final int target) {
        if (root == null) {
            return;
        }
        int number = target - root.val;
        if (root.left == null && root.right == null) {
            if (number == 0) {
                path.addLast(root.val);
                result.add(new LinkedList<>(path));
                path.removeLast();
            }
            return;
        }
        path.addLast(root.val);
        dp(root.left, number);
        dp(root.right, number);
        path.removeLast();
    }
}
