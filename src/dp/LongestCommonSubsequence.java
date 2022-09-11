package dp;

import java.util.Arrays;

//Recursive
public class LongestCommonSubsequence {

    static StringBuilder builder = new StringBuilder();

    static int findLCS(String str1, String str2, int index1, int index2, int[][] dp) {
        int result = 0;
        //Base Case
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (dp[index1][index2] != -1)
            return dp[index1][index2];
        //In case there's a match
        if (str1.charAt(index1) == str2.charAt(index2)) {
            result = 1 + findLCS(str1, str2, index1 - 1, index2 - 1, dp);
            return dp[index1][index2] = result;
        }

        //In case when there no match
        return dp[index1][index2] = Math.max(findLCS(str1, str2, index1, index2 - 1, dp), findLCS(str1, str2, index1 - 1, index2, dp));
    }

    public static int LCStabulation(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] memo = new int[str1.length()][str2.length()];
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                //Match
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    int result = 1 + dp[i - 1][j - 1];
                    dp[i][j] = result;
                } else
                    //Not Match
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str = "abcde";
        String str2 = "acbed";
        int[][] memo = new int[str.length()][str2.length()];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));

        System.out.println(findLCS(str, str2, str.length() - 1, str2.length() - 1, memo));
        System.out.println(LCStabulation(str, str2));
    }
}
