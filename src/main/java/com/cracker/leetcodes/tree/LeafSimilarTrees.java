package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * This is Leetcode number 872: Leaf-Similar Trees.
 */
public class LeafSimilarTrees {

    public boolean leafSimilar(final TreeNode root1, final TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        List<Integer> root1LeafNodes = new ArrayList<>();
        getLeafNodes(root1, root1LeafNodes);
        List<Integer> root2LeafNodes = new ArrayList<>();
        getLeafNodes(root2, root2LeafNodes);
        if (root1LeafNodes.size() != root2LeafNodes.size()) {
            return false;
        }
        for (int i = 0; i < root1LeafNodes.size(); i++) {
            if (!root1LeafNodes.get(i).equals(root2LeafNodes.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    private void getLeafNodes(final TreeNode root, final List<Integer> leafNodes) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafNodes.add(root.val);
        }
        getLeafNodes(root.left, leafNodes);
        getLeafNodes(root.right, leafNodes);
    }

    public boolean leafSimilarPlus(final TreeNode root1, final TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        LeafIterator leafIterator1 = new LeafIterator(root1);
        LeafIterator leafIterator2 = new LeafIterator(root2);
        while (leafIterator1.hasNext() && leafIterator2.hasNext()) {
            if (leafIterator1.next().val != leafIterator2.next().val) {
                return false;
            }
        }
        return !leafIterator1.hasNext() && !leafIterator2.hasNext();
    }
    
    public static class LeafIterator {
        
        private final Deque<TreeNode> stack = new LinkedList<>();
        
        LeafIterator(final TreeNode root) {
            stack.push(root);
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        public TreeNode next() {
            while (hasNext()) {
                TreeNode node = stack.pop();
                if (node.left == null && node.right == null) {
                    return node;
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            return null;
        }
    }
}
