package dp;

import java.util.Arrays;

public class ShortestCommonSuperSequence {
	public static void main(String[] args) {
		String s1 = "brute";
		String s2 = "groot";
		Arrays.stream(findShortestCommonSuperSequence(s1, s2)).forEach(System.out::println);
	}

	private static Object[] findShortestCommonSuperSequence(String s1, String s2) {
		Object[] ans = new Object[2];

		int[][] memoTableLCS = findLCS(s1, s2);
		int n = s1.length();
		int m = s2.length();
		Integer ansLength = n + m - memoTableLCS[n][m];
		ans[0] = ansLength.intValue();
		String ansString = findString(memoTableLCS, s1, s2, n, m);
		ans[1] = ansString;
		return ans;
	}

	private static String findString(int[][] memo, String s1, String s2, int n, int m) {
		StringBuilder sb = new StringBuilder();
		int i = n, j = m;

		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				sb.append(s1.charAt(i - 1));
				i--;
				j--;
			}
			else if (j == 0 && i > 0 || memo[i - 1][j] > memo[i][j - 1]) {
				sb.append(s1.charAt(i - 1));
				i--;
			}
			else {
				sb.append(s2.charAt(j - 1));
				j--;
			}
		}
		if (i > 0) {
			sb.append(s1, 0, i);
		}
		else if (j > 0) {
			sb.append(s2, 0, j);
		}
		return sb.reverse().toString();
	}

	private static int[][] findLCS(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] memo = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
				}
				else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}
		return memo;
	}

}
