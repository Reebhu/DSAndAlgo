package dp;

import java.util.Arrays;

public class MCM {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int n = arr.length;
		int[][] dp = new int[n][n];
		Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
		System.out.println(findMCM(1, n - 1, n, arr, dp));

	}

	static int findMCM(int i, int j, int n, int[] arr, int[][] dp) {
		if (i == j)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int mcm = arr[i - 1] * arr[k] * arr[j] + findMCM(i, k, n, arr, dp) + findMCM(k + 1, j, n, arr, dp);
			min = Math.min(mcm, min);
		}
		return dp[i][j] = min;
	}
}
