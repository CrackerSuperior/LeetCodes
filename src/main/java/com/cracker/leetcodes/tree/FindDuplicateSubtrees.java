package com.cracker.leetcodes.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This is Leetcode number 652: Find Duplicate Subtrees.
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(final TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> treeNodes = new LinkedList<>();
        traverse(treeNodes, map, root);
        return treeNodes;
    }

    private String traverse(final List<TreeNode> treeNodes, final Map<String, Integer> map, final TreeNode root) {
        if (null == root) {
            return "#";
        }
        String left = traverse(treeNodes, map, root.left);
        String right = traverse(treeNodes, map, root.right);
        String subTree = left + "," + right + "," + root.val;
        if (map.containsKey(subTree)) {
            map.put(subTree, map.get(subTree) + 1);
        } else {
            map.put(subTree, 0);
        }
        if (map.get(subTree) == 1) {
            treeNodes.add(root);
        }
        return subTree;
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
