package recursion;

import java.util.ArrayList;

public class CombinationSumI {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        ArrayList<Integer> ds = new ArrayList<>();
        findCombo(arr, 0, target, ds);
    }

    static void findCombo(int[] arr, int i, int target, ArrayList<Integer> ds) {
        if (i == arr.length) {
            if (target == 0)
                System.out.println(ds);
            return;
        }

        //pick when arr[i]<=target
        if (arr[i] <= target) {
            ds.add(arr[i]);
            findCombo(arr, i, target - arr[i], ds);
            ds.remove(ds.size() - 1);
        }

        //not pick
        findCombo(arr, i + 1, target, ds);

    }
}
