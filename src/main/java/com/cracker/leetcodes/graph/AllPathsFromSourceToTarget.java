package com.cracker.leetcodes.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is Leetcode number 797: All Paths From Source to Target.
 */
public class AllPathsFromSourceToTarget {

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(final int[][] graph) {
        if (graph == null) {
            return Collections.emptyList();
        }
        dp(graph, 0, new ArrayList<>());
        return result;
    }

    private void dp(final int[][] graph, final int s, final List<Integer> path) {
        path.add(s);
        if (s == graph.length - 1) {
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        for (int v : graph[s]) {
            dp(graph, v, path);
        }
        path.remove(path.size() - 1);
    }
}
