package com.cracker.leetcodes.array;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Leetcode number 118: Pascal's Triangle.
 */
public class PascalTriangle {

    public List<List<Integer>> generate(final int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }
}
