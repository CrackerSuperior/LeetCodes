package com.cracker.leetcodes.tree;

import com.cracker.leetcodes.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is Leetcode number 508: Most Frequent Subtree Sum.
 */
public class MostFrequentSubtreeSum {
    
    private final Map<Integer, Integer> result = new HashMap<>();

    public int[] findFrequentTreeSum(final TreeNode root) {
        dp(root);
        int max = Integer.MIN_VALUE;
        for (Integer value : result.values()) {
            max = max < value ? value : max;
        }
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue().equals(max)) {
                resultList.add(entry.getKey());
            }
        }
        int[] res = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }
        return res;
    }
    
    private int dp(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dp(root.left);
        int right = dp(root.right);
        int sum = root.val + left + right;
        result.put(sum, result.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
