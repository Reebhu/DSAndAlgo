package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSetSum2 {
    public static void main(String[] args) {
        Set<List<Integer>> subsets = new HashSet<>();
        ArrayList<Integer> ds = new ArrayList<>();
        int[] arr = {1, 2, 2};
        subsetSum(arr, 0, ds, subsets);
        System.out.println(subsets);
    }

    static void subsetSum(int[] arr, int index, List<Integer> res, Set<List<Integer>> subsets) {
        if (index == arr.length) {
            subsets.add(new ArrayList<>(res));
            return;
        }

        //pick
        res.add(arr[index]);
        subsetSum(arr, index + 1, res, subsets);
        res.remove(res.size() - 1);
        //not pick
        subsetSum(arr, index + 1, res, subsets);

    }
}
