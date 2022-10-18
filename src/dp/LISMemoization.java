package dp;

import java.util.Arrays;

//Longest increasing subsequence
public class LISMemoization {

    public static int[] findLIS(int[] arr, int index) {
        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) // Check the earlier computed value to find if the max is present before or not.
                {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }
        return lis;
    }

    static int max(int... values) {
        int maxi = values[0];
        for (int i : values) {
            if (maxi < i)
                maxi = i;
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 2, 3};
        //int arr [] = {10,9,2,5,3,7,101,18};
        int[] lis = findLIS(arr, arr.length - 1);
        System.out.println(max(lis));
    }
}
