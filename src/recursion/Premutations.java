package recursion;

public class Premutations {
	public static void main(String[] args) {
		permute("abc".toCharArray(), 0, 2);
	}

	static void permute(char[] str, int l, int r) {
		if (l == r) {
			System.out.println(String.valueOf(str));
			return;
		}
		for (int i = l; i <= r; i++) {
			swap(str, l, i);
			permute(str, l + 1, r);
			swap(str, l, i);
		}
	}

	static void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
}
