package dp;

public class WildcardMatching {
	public static void main(String[] args) {
		String S1 = "ab*cd";
		String S2 = "abdefcgd";
		int n = S1.length();
		int m = S2.length();

		System.out.println(isMatching(n, m, S1, S2));
		System.out.println(isMatching(S1, S2));
	}

	static boolean isMatching(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		boolean[][] dp = new boolean[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				}
				else if (s1.charAt(i - 1) == '*') {
					dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1];
				}
				else
					dp[i][j] = false;
			}
		}
		return dp[n][m];
	}

	static boolean isMatching(int i, int j, String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		if (j == 0)
			return true;
		if (i == 0) {
			return false;
		}
		if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?') {
			return isMatching(i - 1, j - 1, s1, s2);
		}
		else if (s1.charAt(i - 1) == '*') {
			return isMatching(i, j - 1, s1, s2) || isMatching(i - 1, j - 1, s1, s2);
		}
		return false;
	}

}
