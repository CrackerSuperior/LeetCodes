package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This is Leetcode number 2196: Create Binary Tree From Descriptions.
 */
public class CreateBinaryTreeFromDescriptions {

    public TreeNode createBinaryTree(final int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> childNodes = new HashSet<>();
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int left = description[2];
            if (!nodes.containsKey(parent)) {
                nodes.put(parent, new TreeNode(parent));
            }
            if (!nodes.containsKey(child)) {
                nodes.put(child, new TreeNode(child));
            }
            if (left == 1) {
                nodes.get(parent).left = nodes.get(child);
            } else {
                nodes.get(parent).right = nodes.get(child);
            }
            childNodes.add(child);
        }
        for (Integer node : nodes.keySet()) {
            if (!childNodes.contains(node)) {
                return nodes.get(node);
            }
        }
        return null;
    }

    public TreeNode createBinaryTreePlus(final int[][] descriptions) {
        TreeNode[] nodes = new TreeNode[100001];
        for (int[] node : descriptions) {
            nodes[node[1]] = new TreeNode(node[1]);
        }
        int root = 0;
        for (int[] node : descriptions) {
            if (null == nodes[node[0]]) {
                nodes[node[0]] = new TreeNode(root = node[0]);
            }
            if (node[2] == 1) {
                nodes[node[0]].left = nodes[node[1]];
            } else {
                nodes[node[0]].right = nodes[node[1]];
            }
        }
        return nodes[root];
    }
}
