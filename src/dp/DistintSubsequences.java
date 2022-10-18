package dp;

public class DistintSubsequences {
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        System.out.println(findDistinctSubsequences(s1.length() - 1, s2.length() - 1, s1, s2, memo));
        System.out.println(tabDinstictSub(s1, s2));

    }

    static int findDistinctSubsequences(int index1, int index2, String str1, String str2, int[][] memo) {
        if (index2 < 0) {
            return 1;
        }
        if (index1 < 0) {
            return 0;
        }
        int result = 0;
        if (str1.charAt(index1) == str2.charAt(index2)) {
            result = findDistinctSubsequences(index1 - 1, index2, str1, str2, memo)
                    + findDistinctSubsequences(index1 - 1, index2 - 1, str1, str2, memo);
        }
        else {
            result = findDistinctSubsequences(index1 - 1, index2, str1, str2, memo);
        }

        return memo[index1][index2] = result;
    }

    static int tabDinstictSub(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] memo = new int[str1.length() + 1][str2.length() + 1];

        for (int j = 0; j <= m; j++) {
            memo[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            memo[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j];
                }
                else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        return memo[n][m];
    }
}
