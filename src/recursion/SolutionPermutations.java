package recursion;

import java.util.ArrayList;
import java.util.List;

public class SolutionPermutations {
    static List<Integer> set = new ArrayList<>();

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        findPermutations(a);
        System.out.println(set);
    }

    private static void findPermutations(int[] a) {
        permutations(a, 0);
    }

    static void permutations(int[] arr, int index) {

        if (index == arr.length) {
            //Add it to the array in base case
            set.add(convertToNumber(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permutations(arr, index+1);
            //BackTrack
            swap(arr, i, index);
        }
    }

    private static int convertToNumber(int[] ar) {
        int res = 0;
        for(int i : ar) {
            res = res*10+i;
        }
        return res;
    }

    static void  swap(int [] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
