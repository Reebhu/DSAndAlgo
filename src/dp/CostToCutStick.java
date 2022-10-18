package dp;

import java.util.Arrays;

public class CostToCutStick {
	public static void main(String[] args) {
		int n = 9;
		int[] cuts = {1, 8, 3, 5};
		System.out.println(cost(n, cuts.length, cuts));
	}

	public static int cost(int n, int c, int[] cuts) {
		int[] cut = new int[c + 2];
		cut[0] = 0;
		for (int i = 1; i <= c; i++) {
			cut[i] = cuts[i - 1];
		}
		cut[c + 1] = n;
		int[][] dp = new int[c + 1][c + 1];
		Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
		Arrays.sort(cut);
		return findCost(1, c, cut, dp);
	}

	static int findCost(int i, int j, int[] arr, int[][] dp) {
		if (i > j)
			return 0;
		int cost = Integer.MAX_VALUE;
//        if(dp[i][j]!=-1)
//            return dp[i][j];
		for (int k = i; k <= j; k++) {
			cost = Math.min(cost, arr[j + 1] - arr[i - 1] + findCost(i, k - 1, arr, dp) + findCost(k + 1, j, arr, dp));
		}
		return dp[i][j] = cost;
	}
}
