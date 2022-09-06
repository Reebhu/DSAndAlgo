package dp;

import java.util.Arrays;

public class AllPathsInGridObstracle {
    public static void main(String[] args) {
        int[][] maze = {{0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}};

        int n = maze.length;
        int m = maze[0].length;

        System.out.println(countWays(n, m, maze));
    }

    private static int countWays(int n, int m, int[][] grid) {
        int sum = 0;
        int i = 0, j = 0;
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        sum = way(i, j, m, n, dp, grid);
        return sum;
    }

    static int way(int i, int j, int m, int n, int[][] dp, int[][] grid) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (i > n - 1 || j > m - 1) {
            return 0;
        }
        if (grid[i][j] == -1)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];


        //go down                    //go right
        return dp[i][j] = way(i + 1, j, m, n, dp, grid) + way(i, j + 1, m, n, dp, grid);

    }
}
