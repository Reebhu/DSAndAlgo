package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestDivisibleSequenece {
	public static void main(String[] args) {
		int[] arr = {1, 4, 8, 7, 16};
		System.out.println(findLDS(arr));
	}

	static List<Integer> findLDS(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		int[] lds = new int[n];
		Arrays.fill(lds, 1);
		int[] hash = new int[n];
		Arrays.fill(hash, -1);
		int lastInd = 0;
		int max = 0;
		for (int i = 1; i < n; i++) {

			for (int j = 0; j < i; j++) {
				if (arr[i] % arr[j] == 0 && lds[i] < lds[j] + 1) {
					lds[i] = lds[j] + 1;
					hash[i] = j;
				}
			}
			if (max < lds[i]) {
				lastInd = i;
				max = lds[i];
			}
		}
		List<Integer> printLis = new ArrayList<>();
		while (lastInd >= 0) {
			//maxInd = hash[maxInd];
			printLis.add(arr[lastInd]);
			lastInd = hash[lastInd];
		}
		return printLis;
	}
}
