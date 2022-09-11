package dp;

public class SubsetSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int target = 6;
        boolean[][] dp = new boolean[n][target + 1];
        boolean ans = findSubSetSumTab(n - 1, arr, target, dp);
        System.out.println(ans);
    }

    private static boolean findSubSetSum(int index, int[] arr, int target, Boolean[][] dp) {
        if (target == 0)
            return true;

        if (index == 0) {
            return arr[0] == target;
        }
        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean take = false, notTake = false;
        //pick
        if (target >= arr[index])
            take = findSubSetSum(index - 1, arr, target - arr[index], dp);

        //not pick
        notTake = findSubSetSum(index - 1, arr, target, dp);

        return dp[index][target] = (take || notTake);
    }

    private static boolean findSubSetSumTab(int index, int[] arr, int target, boolean[][] dp) {

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
        return dp[arr.length - 1][target];
    }
}
