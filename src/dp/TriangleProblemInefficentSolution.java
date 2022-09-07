package dp;

import java.util.Arrays;

public class TriangleProblemInefficentSolution {
    public static void main(String[] args) {
        int[][] triangle = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};

        int n = triangle.length;

        System.out.println(minimumPathSum(triangle, n));
    }

    private static int minimumPathSum(int[][] triangle, int n) {
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
            int res = solve(triangle, n - 1, i, dp);
            min = Math.min(min, res);
            System.out.println(res);
        }
        return min;
    }


    private static int solve(int[][] triangle, int i, int j, int[][] dp) {
        if (i == 0)
            return triangle[0][0];
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = triangle[i][j];
        int diagonal = triangle[i][j];
        if (i > 0 && i > j) {
            up += solve(triangle, i - 1, j, dp);
        } else
            up = (int) Math.pow(10, 9);
        if (j > 0) {
            diagonal += solve(triangle, i - 1, j - 1, dp);
        } else diagonal = (int) Math.pow(10, 9);
        return dp[i][j] = Math.min(up, diagonal);
    }
}
