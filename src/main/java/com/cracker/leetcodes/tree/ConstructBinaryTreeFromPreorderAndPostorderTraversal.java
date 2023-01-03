package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 889: Construct Binary Tree from Preorder and Postorder Traversal.
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public TreeNode constructFromPrePost(final int[] preorder, final int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(map, preorder, 0, preorder.length - 1,
                0, postorder.length - 1);
    }

    private TreeNode build(final Map<Integer, Integer> map, final int[] preorder, final int preStart, final int preEnd,
                           final int postStart, final int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int rootVal = preorder[preStart];
        int leftRootVal = preorder[preStart + 1];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(leftRootVal);
        int leftSize = index - postStart + 1;
        root.left = build(map, preorder, preStart + 1, preStart + leftSize,
                postStart, index);
        root.right = build(map, preorder, preStart + leftSize + 1, preEnd,
                index + 1, postEnd - 1);
        return root;
    }
}
