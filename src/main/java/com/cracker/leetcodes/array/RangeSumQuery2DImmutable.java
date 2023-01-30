package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 304: Range Sum Query 2D - Immutable.
 */
public class RangeSumQuery2DImmutable {

    static class NumMatrix {

        private final int[][] preSum;
        
        NumMatrix(final int[][] matrix) {
            int length = matrix.length;
            int width = matrix[0].length;
            preSum = new int[length + 1][width + 1];
            for (int i = 1; i <= length; i++) {
                for (int j = 1; j <= width; j++) {
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(final int row1, final int col1, final int row2, final int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
        }
    }
}
