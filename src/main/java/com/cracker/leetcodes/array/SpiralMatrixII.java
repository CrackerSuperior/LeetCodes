package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 59: Spiral Matrix II.
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(final int n) {
        int[][] result = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        while (num <= n * n) {
            if (up <= down) {
                for (int i = left; i <= right; i++) {
                    result[up][i] = num++;
                }
                up++;
            }
            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    result[i][right] = num++;
                }
                right--;
            }
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    result[down][i] = num++;
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result[i][left] = num++;
                }
                left++;
            }
        }
        return result;
    }
}
