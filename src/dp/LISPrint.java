package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LISPrint {
	public static List<Integer> findLIS(int[] arr, int index) {
		int[] lis = new int[arr.length];
		Arrays.fill(lis, 1);
		int[] hash = new int[arr.length];
		Arrays.fill(hash, -1);
		int max = 0;
		int maxInd = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[j] + 1 > lis[i]) // Check the earlier computed value to find if the max is present before or not.
				{
					lis[i] = 1 + lis[j];
					hash[i] = j;
				}
			}
			if (max < lis[i]) {
				max = lis[i];
				maxInd = i;
			}
		}
		List<Integer> printLis = new ArrayList<>();
		while (maxInd >= 0) {
			//maxInd = hash[maxInd];
			printLis.add(arr[maxInd]);
			maxInd = hash[maxInd];
		}
		return printLis;
	}

	public static void main(String[] args) {
		//int[] arr = {0, 1, 0, 3, 2, 3};
		int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		List<Integer> lis = findLIS(arr, arr.length - 1);
		System.out.println(lis);
	}
}
