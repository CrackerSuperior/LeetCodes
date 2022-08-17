package com.cracker.leetcodes.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is Leetcode number 1104: Path In Zigzag Labelled Binary Tree.
 */
public class PathInZigzagLabelledBinaryTree {

    public List<Integer> pathInZigZagTree(final int label) {
        List<Integer> result = new ArrayList<>();
        int val = label;
        while (val > 0) {
            result.add(val);
            val >>= 1;
        }
        Collections.reverse(result);
        int depth = result.size();
        int l;
        int r;
        for (int i = 0; i < depth; i++) {
            if ((depth & 1) != (i & 1)) {
                continue;
            }
            l = 1 << i;
            r = l + l - 1;
            result.set(i, r - result.get(i) + l);
        }
        return result;
    }
}
