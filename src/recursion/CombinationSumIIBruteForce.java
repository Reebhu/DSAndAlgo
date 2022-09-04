package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CombinationSumIIBruteForce {
    static Set<ArrayList<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        ArrayList<Integer> ds = new ArrayList<>();
        Arrays.sort(arr);
        findCombo(arr, 0, target, ds);

        System.out.println(set);
    }

    static void findCombo(int[] arr, int i, int target, ArrayList<Integer> ds) {
        if (i == arr.length) {
            if (target == 0) {
                // System.out.println(ds);
                set.add(new ArrayList<>(ds));
            }
            return;
        }

        //pick when arr[i]<=target
        if (arr[i] <= target) {
            ds.add(arr[i]);
            findCombo(arr, i + 1, target - arr[i], ds);
            ds.remove(ds.size() - 1);
        }

        //not pick
        findCombo(arr, i + 1, target, ds);
        return;
    }
}
