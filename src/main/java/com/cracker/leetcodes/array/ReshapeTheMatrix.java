package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 566: Reshape the Matrix.
 */
public class ReshapeTheMatrix {

    public int[][] matrixReshape(final int[][] mat, final int r, final int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] nums = new int[r][c];
        for (int i = 0; i < m * n; ++i) {
            nums[i / c][i % c] = mat[i / n][i % n];
        }
        return nums;
    }
}
