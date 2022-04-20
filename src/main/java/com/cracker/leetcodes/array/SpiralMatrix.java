package com.cracker.leetcodes.array;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Leetcode number 54: Spiral Matrix.
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(final int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        List<Integer> result = new ArrayList<>();
        while (result.size() < m * n) {
            if (up <= down) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[up][i]);
                }
                up++;
            }
            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
