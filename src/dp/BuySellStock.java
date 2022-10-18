package dp;

import java.util.Arrays;

public class BuySellStock {
	public static void main(String[] args) {
		int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
		int cap = 2;
		int n = arr.length;
		int[][][] dp = new int[n][2][cap + 1];
		for (int[][] i : dp) {
			for (int[] j : i) {
				Arrays.fill(j, -1);
			}
		}
		System.out.println(findProfit(arr, 0, 0, cap, dp));
		System.out.println(findProfitTabSpace(arr, cap));
	}

	static int findProfit(int[] arr, int index, int buy, int cap, int[][][] dp) {

		if (cap == 0)
			return 0;
		if (index == arr.length)
			return 0;
		int profit = 0;
		if (dp[index][buy][cap] != -1)
			return dp[index][buy][cap];
		if (buy == 0) {
			profit = Math.max(findProfit(arr, index + 1, 0, cap, dp), findProfit(arr, index + 1, 1, cap, dp) - arr[index]);
		}
		else
			profit = Math.max(arr[index] + findProfit(arr, index + 1, 0, cap - 1, dp), findProfit(arr, index + 1, 1, cap, dp));
		return dp[index][buy][cap] = profit;
	}

	static int findProfitTab(int[] arr, int cap) {
		int n = arr.length;
		int[][][] dp = new int[n + 1][2][cap + 1];

		for (int i = n - 1; i >= 0; i--) {
			for (int k = 1; k <= cap; k++) {
				dp[i][0][k] = Math.max(dp[i + 1][0][k], dp[i + 1][1][k] - arr[i]);
				dp[i][1][k] = Math.max(arr[i] + dp[i + 1][0][k - 1], dp[i + 1][1][k]);
			}
		}
		return dp[0][0][cap];
	}

	static int findProfitTabSpace(int[] arr, int cap) {
		int n = arr.length;
		int[][][] dp = new int[n + 1][2][cap + 1];

		int[][] next = new int[2][cap + 1];
		int[][] curr = new int[2][cap + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int k = 1; k <= cap; k++) {
				curr[0][k] = Math.max(next[0][k], next[1][k] - arr[i]);
				curr[1][k] = Math.max(arr[i] + next[0][k - 1], next[1][k]);
				next = curr;
			}
		}
		return next[0][cap];
	}
}
