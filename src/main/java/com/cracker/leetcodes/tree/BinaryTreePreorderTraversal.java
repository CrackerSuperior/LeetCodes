package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * This is Leetcode number 144: Binary Tree Preorder Traversal.
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(final TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dp(root, result);
        return result;
    }

    private void dp(final TreeNode root, final List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        dp(root.left, result);
        dp(root.right, result);
    }

    public List<Integer> preorderTraversalPlus(final TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || null != temp) {
            while (null != temp) {
                result.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            temp = temp.right;
        }
        return result;
    }
}
