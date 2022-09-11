package dp;

import java.util.Arrays;

public class CherryPickProblem {
    public static void main(String[] args) {
        int[][] matrix = {{2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}};
        int n = matrix.length;
        int m = matrix[0].length;
        int[][][] dp = new int[n][m][m];
        for (int[][] i : dp)
            for (int[] j : i)
                Arrays.fill(j, -1);

        System.out.println(findMaxChocos(0, 0, m - 1, matrix, dp));
        System.out.println(solve(n, m, matrix, dp));
    }

    static int findMaxChocos(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;
        if (j1 < 0 || j2 < 0 || j1 > m - 1 || j2 > m - 1) {
            return (int) Math.pow(-10, 9);
        }
        if (i == n - 1) {
            return j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = findMaxChocos(i + 1, j1 + dj1, j2 + dj2, grid, dp);
                if (j1 == j2) {
                    value += grid[i][j1];
                } else
                    value += grid[i][j1] + grid[i][j2];

                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2] = max;
    }

    static int solve(int n, int m, int[][] grid, int[][][] dp) {
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                dp[n - 1][j1][j2] = j1 == j2 ? grid[n - 1][j1] : grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int value;
                            if (j1 + dj1 < 0 || j2 + dj2 < 0 || j1 + dj1 > m - 1 || j2 + dj2 > m - 1)
                                value = (int) Math.pow(-10, 9);
                            else
                                value = dp[i + 1][j1 + dj1][j2 + dj2];
                            if (j1 == j2) {
                                value += grid[i][j1];
                            } else
                                value += grid[i][j1] + grid[i][j2];
                            max = Math.max(max, value);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m - 1];
    }
}