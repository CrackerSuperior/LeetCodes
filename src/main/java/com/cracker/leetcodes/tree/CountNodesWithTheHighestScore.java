package com.cracker.leetcodes.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * This is Leetcode number 2049: Count Nodes With the Highest Score.
 */
public class CountNodesWithTheHighestScore {

    private int[][] tree;

    private final Map<Long, Integer> scores = new HashMap<>();

    public int countHighestScoreNodes(final int[] parents) {
        buildTree(parents);
        countNode(0);
        long max = 0;
        for (Long score : scores.keySet()) {
            max = Math.max(max, score);
        }
        return scores.get(max);
    }

    private int countNode(final int root) {
        if (root == -1) {
            return 0;
        }
        int n = tree.length;
        int left = countNode(tree[root][0]);
        int right = countNode(tree[root][1]);
        int other = n - left - right - 1;
        long score = (long) Math.max(left, 1) * Math.max(right, 1) * Math.max(other, 1);
        scores.put(score, scores.getOrDefault(score, 0) + 1);
        return left + right + 1;
    }

    private void buildTree(final int[] parents) {
        int n = parents.length;
        tree = new int[n][2];
        for (int i = 0; i < n; i++) {
            tree[i][0] = tree[i][1] = -1;
        }
        for (int i = 1; i < n; i++) {
            int parent = parents[i];
            if (tree[parent][0] == -1) {
                tree[parent][0] = i;
            } else {
                tree[parent][1] = i;
            }
        }
    }
}
