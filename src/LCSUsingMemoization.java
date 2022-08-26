//O(NxM)
public class LCSUsingMemoization {
    static int findLCS(String str1, String str2, int i, int j, int[][] dp) {
        int result = 0;
        //Base Case
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        //In case there's a match
        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = 1 + findLCS(str1, str2, i - 1, j - 1, dp);
            return dp[i][j];
        }

        //In case when there no match
        dp[i][j] = Math.max(findLCS(str1, str2, i - 1, j, dp), findLCS(str1, str2, i, j - 1, dp));
        return dp[i][j];
    }

    public static void main(String[] args) {
        String str = "abcde";
        String str2 = "acbed";
        int n = str.length();
        int m = str2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(findLCS(str, str2, str.length() - 1, str2.length() - 1, dp));
    }
}
