package dp;

public class LongestSubStringWIthoutRepeatation {
	public static void main(String[] args) {
		LongestSubStringWIthoutRepeatation obj = new LongestSubStringWIthoutRepeatation();
		System.out.println(obj.lengthOfLongestSubstring("ab"));
	}

	public int lengthOfLongestSubstring(String s) {
		char[] charArray = s.toCharArray();
		int n = s.length();

		for (int i = 0; i < n - 1; i++) {
			char start = charArray[i];
			for (int j = i + 1; j <= n - 1; j++) {
				if (charArray[i] != charArray[j]) {

				}
			}
		}
		return 0;
	}
}
