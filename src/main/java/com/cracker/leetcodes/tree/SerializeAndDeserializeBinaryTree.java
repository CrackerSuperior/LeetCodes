package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * his is Leetcode number 297: Serialize and Deserialize Binary Tree.
 */
public class SerializeAndDeserializeBinaryTree {

    public String serialize(final TreeNode root) {
        LinkedList<String> results = new LinkedList<>();
        build(results, root);
        return String.join(",", results);
    }

    public TreeNode deserialize(final String data) {
        String[] results = data.split(",");
        LinkedList<String> strings = new LinkedList<>(Arrays.asList(results));
        return build(strings);
    }

    private void build(final List<String> results, final TreeNode root) {
        if (null == root) {
            results.add("null");
            return;
        }
        results.add(String.valueOf(root.val));
        build(results, root.left);
        build(results, root.right);
    }

    private TreeNode build(final LinkedList<String> results) {
        if (results.isEmpty()) {
            return null;
        }
        String first = results.removeFirst();
        if ("null".equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = build(results);
        root.right = build(results);
        return root;
    }
}
