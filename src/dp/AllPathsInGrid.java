package dp;

import java.util.Arrays;

public class AllPathsInGrid {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        System.out.println(countWays(m, n));
    }

    private static int countWays(int n, int m) {
        int[][] grid = new int[n][m];
        int sum = 0;
        int i = n - 1, j = m - 1;
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        sum = way(i, j, m, n, dp);
        return sum;
    }

    static int way(int i, int j, int m, int n, int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];


        //go down                    //go right
        return dp[i][j] = way(i - 1, j, m, n, dp) + way(i, j - 1, m, n, dp);

    }
}
