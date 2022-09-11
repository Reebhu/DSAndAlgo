package dp;

public class SubsetSumPartitionToDifferenceD {
    public static void main(String[] args) {
        int[] arr = {8, 5, 6, 4, 7};
        int n = arr.length;
        int difference = 3;
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        //s1 = totalSum-s2
        // |s1-s2| = D
        // TotalSum-s2-s2 = D
        // s2 = totalSum-D/2
        int target = (totalSum - difference) / 2;
        int[][] dp = new int[arr.length][target + 1];
        int ans = findSubset(n - 1, arr, target, dp);
        System.out.println(ans);

    }

    static int findSubset(int index, int[] arr, int target, int[][] dp) {
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        if (target >= arr[0]) {
            dp[0][arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int k = 0; k <= target; k++) {
                int pick = 0, notPick = 0;
                if (k >= arr[i])
                    pick = dp[i - 1][k - arr[i]];
                notPick = dp[i - 1][k];
                dp[i][k] = pick + notPick;
            }
        }
        return dp[n - 1][target];
    }
}