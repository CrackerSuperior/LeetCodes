package com.cracker.leetcodes.array;

/**
 * This is Leetcode number 48: Rotate Image.
 */
public class RotateImage {

    public void rotate(final int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] ints : matrix) {
            int i = 0;
            int j = ints.length - 1;
            while (i < j) {
                int temp = ints[i];
                ints[i] = ints[j];
                ints[j] = temp;
                i++;
                j--;
            }
        }
    }
}
