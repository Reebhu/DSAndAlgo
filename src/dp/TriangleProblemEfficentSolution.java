package dp;

import java.util.Arrays;

public class TriangleProblemEfficentSolution {
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

        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int res = solve(triangle, 0, 0, dp);
        min = Math.min(min, res);
        return min;
    }


    private static int solve(int[][] triangle, int i, int j, int[][] dp) {
        if (i == triangle.length - 1)
            return dp[i][j] = triangle[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int down = triangle[i][j] + solve(triangle, i + 1, j, dp);
        int diagonal = triangle[i][j] + solve(triangle, i + 1, j + 1, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }
}
