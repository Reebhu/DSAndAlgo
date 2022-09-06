package dp;

import java.util.Arrays;

public class FrogJumpKSpaces {

    public static void main(String[] args) {
        int[] height = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int k = 2;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(solve(n, height, dp, k));
    }

    private static int solve(int n, int[] height, int[] dp, int k) {
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    min = Math.min(min, jump);
                }
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }

    private static int min(int[] arr, int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }


}
