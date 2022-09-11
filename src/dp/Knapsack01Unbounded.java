package dp;

import java.util.Arrays;

public class Knapsack01Unbounded {
    public static void main(String[] args) {
        int[] profit = {60, 100, 100, 120};
        int[] weight = {10, 20, 20, 30};
        int n = weight.length;
        int totalWeight = 50;
        int[][] memo = new int[weight.length][totalWeight + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));

        int ans = findKnapsackMemo(n - 1, totalWeight, profit, weight, memo); //unbounded
        int res = findKnapsackTab(totalWeight, profit, weight); //bounded
        System.out.println(res);
    }

    private static int findKnapsackMemo(int i, int totalWeight, int[] profit, int[] weight, int[][] memo) {
        if (totalWeight == 0) {
            return 0;
        }
        if (i == 0) {
            if (totalWeight % weight[i] == 0)
                return profit[0] * totalWeight / weight[i];
            return 0;
        }
        if (memo[i][totalWeight] != -1)
            return memo[i][totalWeight];
        int pick = 0, notPick = 0;
        if (weight[i] <= totalWeight)
            pick = profit[i] + findKnapsackMemo(i - 1, totalWeight - weight[i], profit, weight, memo);
        notPick = findKnapsackMemo(i - 1, totalWeight, profit, weight, memo);

        return memo[i][totalWeight] = Math.max(pick, notPick);
    }

    private static int findKnapsackTab(int totalWeight, int[] profit, int[] weight) {
        int[][] dp = new int[weight.length][totalWeight + 1];
        int n = weight.length;
        for (int wt = weight[0]; wt <= totalWeight; wt++) {
            dp[0][wt] = profit[0];
        }

        for (int i = 1; i < n; i++) {
            for (int k = 0; k <= totalWeight; k++) {
                int pick = 0, notPick = 0;
                if (weight[i] <= k)
                    pick = profit[i] + dp[i - 1][k - weight[i]];
                else
                    pick = Integer.MIN_VALUE;
                notPick = dp[i - 1][k];

                dp[i][k] = Math.max(pick, notPick);
            }
        }
        return dp[n - 1][totalWeight];
    }
}
