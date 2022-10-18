package dp;

public class EditDistance {
	public static void main(String[] args) {
		String s1 = "horse";
		String s2 = "ros";
		System.out.println(findEditDistanceTab(s1, s2));
	}

	static int findEditDistanceTab(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] memo = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			memo[i][0] = i;
		}
		for (int j = 0; j <= m; j++) {
			memo[0][j] = j;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					memo[i][j] = memo[i - 1][j - 1];
				}
				else {
					memo[i][j] = 1 + Math.min(memo[i - 1][j], Math.min(memo[i][j - 1], memo[i - 1][j - 1]));
				}
			}
		}
		return memo[n][m];
	}
}
