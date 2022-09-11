package dp;

public class MinimumSubsetSum {
    private static boolean[][] findSubSetSumTab(int index, int[] arr, int target, boolean[][] dp) {

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= target)
            dp[0][arr[0]] = true;
        for (int i = 1; i < arr.length; i++) {
            for (int k = 1; k <= target; k++) {
                boolean take = false, notTake = false;
                //pick
                if (k >= arr[i])
                    take = dp[i - 1][k - arr[i]];

                //not pick
                notTake = dp[i - 1][k];

                dp[i][k] = (take || notTake);
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 5};
        int n = arr.length;
        int target = 0;
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        target = totalSum;
        boolean[][] dp = new boolean[n][target + 1];
        boolean[][] ans = findSubSetSumTab(n - 1, arr, target, dp);
        // System.out.println(ans);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= totalSum; i++) {
            if (dp[arr.length - 1][i]) {
                int s1 = i;
                int s2 = totalSum - i;
                min = Math.min(min, Math.abs(s2 - s1));
            }
        }
        System.out.println(min);
    }
}
