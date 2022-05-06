package com.cracker.leetcodes.math;

/**
 * This is Leetcode number 509: Fibonacci Number.
 */
public class FibonacciNumber {

    public int fib(final int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fibMemoMode(final int n) {
        int[] memo = new int[n + 1];
        return fibMemoModeDp(memo, n);
    }

    private int fibMemoModeDp(final int[] memo, final int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibMemoModeDp(memo, n - 1) + fibMemoModeDp(memo, n - 2);
        return memo[n];
    }

    public int fibDPTable(final int n) {
        int[] dPTable = new int[n + 1];
        if (n == 0 || n == 1) {
            return n;
        }
        dPTable[0] = 0;
        dPTable[1] = 1;
        for (int i = 2; i <= n; i++) {
            dPTable[i] = dPTable[i - 1] + dPTable[i - 2];
        }
        return dPTable[n];
    }

    public int fibDPTablePlus(final int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int dPTable1 = 1;
        int dPTable2 = 0;
        for (int i = 2; i <= n; i++) {
            int dPTable = dPTable1 + dPTable2;
            dPTable2 = dPTable1;
            dPTable1 = dPTable;
        }
        return dPTable1;
    }
}
