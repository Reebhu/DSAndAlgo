package dp;

import util.Util;

import java.util.Arrays;

public class MinimunPathSumInGrid {
    static int minSum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] matrix = {{5, 9, 6},
                {11, 5, 2}};

        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(countWays(n, m, matrix));
    }

    private static int countWays(int n, int m, int[][] grid) {
        int sum = 0;
        int i = 0, j = 0;
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int sumSoFar = 0;
        sum = way(i, j, m, n, dp, grid, sumSoFar);
        Util.print2DArray(dp);
        return sum;
    }

    static int way(int i, int j, int m, int n, int[][] dp, int[][] grid, int sum) {
        if (i == n - 1 && j == m - 1) {
            return dp[i][j] = grid[i][j];
        }
        if (i > n - 1 || j > m - 1) {
            return (int) Math.pow(10, 9);
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        int down = way(i + 1, j, m, n, dp, grid, sum) + grid[i][j];
        int right = way(i, j + 1, m, n, dp, grid, sum) + grid[i][j];

        return dp[i][j] = Math.min(down, right);

    }

}
