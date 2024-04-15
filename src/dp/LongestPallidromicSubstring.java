package dp;

public class LongestPallidromicSubstring {
	/* FInd longest pallidromic Substring
	 * edrtababafdf
	 * abcd
	 * */
	public static void main(String[] args) {
		//findLongestPallidromicSubstringBruteForce("edrtfdf");
		String result = findLPSUsingMidPointExpansion("aafdf");
	}

	static String findLPSUsingMidPointExpansion(String str) {
		int maxLen = Integer.MIN_VALUE;
		String result = null;
		for (int i = 0; i < str.length() - 1; i++) {

			String odd = expandFromCenter(str, i, i);
			String even = expandFromCenter(str, i, i + 1);

			if (odd.length() > maxLen) {
				maxLen = odd.length();
				result = odd;
			}

			if (even.length() > maxLen) {
				maxLen = even.length();
				result = even;
			}
		}
		System.out.println(result);
		return result;
	}

	private static String expandFromCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	private static String findLPS(String str) {
		String revStr = new StringBuilder(str).reverse().toString();
		int n = str.length();
		int max = Integer.MIN_VALUE;
		System.out.println(findLongestCommonSubstring(str, revStr, n - 1, n - 1));
		return null;
	}

	public static int findLongestCommonSubstring(String str, String str2, int i, int j) {
		if (i < 0 || j < 0)
			return 0;

		if (str.charAt(i) == str2.charAt(j)) {
			return 1 + findLongestCommonSubstring(str, str2, i - 1, j - 1);
		}

		return Math.max(findLongestCommonSubstring(str, str2, i, j - 1), findLongestCommonSubstring(str, str2, i - 1, j));

	}

	public static void findLongestPallidromicSubstringBruteForce(String str) {
		int max = Integer.MIN_VALUE;
		String result = null;
		char[] chaArr = str.toCharArray();
		for (int i = 0; i < chaArr.length; i++) {
			for (int j = i + 1; j < chaArr.length; j++) {
				String substring = str.substring(i, j + 1);
				if (checkPallidrome(substring) && substring.length() > max) {
					max = substring.length();
					result = substring;
				}
			}
		}
		if (result != null)
			System.out.println(result);
		else
			System.out.println("No pallidromic substring");
	}

	public static boolean checkPallidrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
