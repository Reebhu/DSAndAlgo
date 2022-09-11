package dp;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};
        int min = findMinFallingPath(matrix);
        System.out.println(min);
    }

    static int findMinFallingPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int min = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            min = Math.max(min, solve(n, m, grid));
        }
        return min;
    }

    static int solve(int n, int m, int[][] grid) {
        int max = 0;
        int[][] dp = new int[n][m];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        for (int j = 0; j < m; j++)
            dp[0][j] = grid[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int lDiagonal;
                int rDiagonal;
                int up = lDiagonal = rDiagonal = (int) Math.pow(-10, 9);

                up = grid[i][j] + dp[i - 1][j];
                if (j > 0)
                    lDiagonal = grid[i][j] + dp[i - 1][j - 1];
                if (j < grid[0].length - 1)
                    rDiagonal = grid[i][j] + dp[i - 1][j + 1];
                dp[i][j] = Math.max(up, Math.max(lDiagonal, rDiagonal));
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }
}
