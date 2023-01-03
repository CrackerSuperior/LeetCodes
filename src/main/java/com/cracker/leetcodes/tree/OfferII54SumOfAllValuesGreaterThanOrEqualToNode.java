package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

/**
 * This is Leetcode Offer II 54: The sum of all values greater than or equal to the node.
 *      This question is the same as leetcode's 538 and 1038 questions.
 */
public class OfferII54SumOfAllValuesGreaterThanOrEqualToNode {

    private int sum;

    public TreeNode convertBST(final TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
