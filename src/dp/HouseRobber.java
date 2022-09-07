package dp;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 3, 100};
        int n = arr.length;
        int[] dp = new int[n];
        System.out.println(solve(0, n - 2, arr, dp));
        System.out.println(solve(1, n - 1, arr, dp));
    }

    private static int solve(int l, int n, int[] arr, int[] dp) {
        dp[l] = arr[l];
        int max = Integer.MIN_VALUE;
        for (int i = l + 1; i <= n; i++) {
            int pick = arr[i];
            if (i > l + 1) {
                pick = pick + dp[i - 2];
            }
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n];
    }

}
