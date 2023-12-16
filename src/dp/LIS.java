package dp;

public class LIS {
	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 3, 2, 3};
		System.out.println(findLIS(0, -1, arr));
		System.out.println(findLisTab(arr));
	}

	static int findLIS(int index, int prev, int[] arr) {
		int n = arr.length;
		if (index == n) {
			return 0;
		}

		int pick = 0;
		int notpick = findLIS(index + 1, prev, arr);

		if (prev == -1 || arr[index] > arr[prev])
			pick = 1 + findLIS(index + 1, index, arr);

		return Math.max(pick, notpick);
	}

	static int findLisTab(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n + 1][n + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i - 1; j >= -1; j--) {
				int notTake = dp[i + 1][j + 1];
				int take = 0;
				if (j == -1 || arr[i] > arr[j])
					take = 1 + dp[i + 1][i + 1];
				dp[i][j + 1] = Math.max(take, notTake);

			}
		}
		return dp[0][0];
	}
}
