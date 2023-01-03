package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 105: Construct Binary Tree from Preorder and Inorder Traversal.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(final int[] preorder, final int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(map, preorder, 0, preorder.length - 1,
                0);
    }

    private TreeNode build(final Map<Integer, Integer> map, final int[] preorder, final int preStart, final int preEnd, final int inoStart) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        Integer index = map.get(rootVal);
        int leftSize = index - inoStart;
        root.left = build(map, preorder, preStart + 1, preStart + leftSize,
                inoStart);
        root.right = build(map, preorder, preStart + leftSize + 1, preEnd,
                index + 1);
        return root;
    }
}
