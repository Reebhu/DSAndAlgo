package dp;

public class PrintLCS {
    public static int[][] LCStabulation(String str1, String str2) {
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
        return dp;
    }

    public static void main(String[] args) {
        String str = "abcde";
        String str2 = "acbed";
        int[][] memo = LCStabulation(str, str2);
        printLCS(memo, str, str2);
    }

    private static void printLCS(int[][] memo, String str, String str2) {
        int i = str.length();
        int j = str2.length();
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str.charAt(i - 1));
                i--;
                j--;
            } else if (memo[i - 1][j] > memo[i][j - 1]) {
                i--;
            } else
                j--;
        }
        System.out.println(sb.reverse());
    }


}
