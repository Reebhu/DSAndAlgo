package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestStringChain {
	public static void main(String[] args) {
		String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
		System.out.println(findLongestStringChain(words));
	}

	static List<String> findLongestStringChain(String[] words) {
		int n = words.length;
		int[] lsc = new int[n];
		Arrays.fill(lsc, 1);
		int[] hash = new int[n];
		Arrays.fill(hash, -1);

		int max = 0;
		int maxInd = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (compare(words[i], words[j]) && lsc[i] < lsc[j] + 1) {
					lsc[i] = lsc[j] + 1;
					hash[i] = j;
				}
			}
			if (max < lsc[i]) {
				max = lsc[i];
				maxInd = i;
			}
		}
		List<String> res = new ArrayList<>();
		while (maxInd >= 0) {
			String word = words[maxInd];
			res.add(word);
			maxInd = hash[maxInd];
		}
		return res;
	}

	private static boolean compare(String s1, String s2) {
		if (s1.length() - s2.length() != 1) return false;
		int i = 0, j = 0;

		while (i < s1.length()) {
			if (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			}
			else
				i++;
		}
		return i == s1.length() && j == s2.length();
	}
}
