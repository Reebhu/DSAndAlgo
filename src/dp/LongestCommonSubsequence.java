package dp;

//Recursive
public class LongestCommonSubsequence {

    static StringBuilder builder = new StringBuilder();

    static int findLCS(String str1, String str2, int index1, int index2) {
        int result = 0;
        //Base Case
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        //In case there's a match
        if (str1.charAt(index1) == str2.charAt(index2)) {
            result = 1 + findLCS(str1, str2, index1 - 1, index2 - 1);
            return result;
        }

        //In case when there no match
        return Math.max(findLCS(str1, str2, index1, index2 - 1), findLCS(str1, str2, index1 - 1, index2));
    }

    public static void main(String[] args) {
        String str = "abcde";
        String str2 = "acbed";

        System.out.println(findLCS(str, str2, str.length() - 1, str2.length() - 1));
        System.out.println(builder.toString());
    }
}
