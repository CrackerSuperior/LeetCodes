package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 2319: Check if Matrix Is X-Matrix.
 */
public class CheckIfMatrixIsXMatrix {

    public boolean checkXMatrix(final int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if ((grid[i][j] == 0) == (i == j || i + j == grid.length - 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
