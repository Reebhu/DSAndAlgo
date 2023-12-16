package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		System.out.println(generateParanthesis(3));
	}

	static List<String> generateParanthesis(int n) {
		List<String> result = new ArrayList<>();
		parentheisis(n, result, 0, 0, "");
		return result;
	}

	private static void parentheisis(int n, List<String> result, int l, int r, String res) {
		if (l + r >= n * 2) {
			result.add(res);
			return;
		}
		if (l < n) {
			res = res + "(";
			parentheisis(n, result, l + 1, r, res);
			res = res.substring(0, res.length() - 1);
		}

		if (r < l) {
			res = res + ")";
			parentheisis(n, result, l, r + 1, res);
			res = res.substring(0, res.length() - 1);
		}
	}
}
