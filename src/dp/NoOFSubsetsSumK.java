package dp;

import java.util.Arrays;

public class NoOFSubsetsSumK {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};

        int k = 2;

        int[][] dp = new int[arr.length][k + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        System.out.println(findNoOfSubsets(arr.length - 1, k, arr, dp));
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, 0));
        System.out.println(findNoOfSubsetsTab(k, arr, dp));
    }

    static int findNoOfSubsets(int i, int k, int[] arr, int[][] dp) {
        if (k == 0) {
            return 1;
        }
        if (i == 0) {
            return arr[i] == k ? 1 : 0;
        }
        if (dp[i][k] != -1)
            return dp[i][k];
        int pick = 0, notPick = 0;
        if (k >= arr[i]) pick = findNoOfSubsets(i - 1, k - arr[i], arr, dp);
        notPick = findNoOfSubsets(i - 1, k, arr, dp);

        return dp[i][k] = pick + notPick;
    }

    static int findNoOfSubsetsTab(int k, int[] arr, int[][] dp) {

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= k) dp[0][arr[0]] = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int target = 0; target <= k; target++) {
                int pick = 0, notPick = 0;
                if (target >= arr[i]) pick = dp[i - 1][target - arr[i]];
                notPick = dp[i - 1][target];

                dp[i][target] = pick + notPick;
            }
        }

        return dp[arr.length - 1][k];

    }
}
