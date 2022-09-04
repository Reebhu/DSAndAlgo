package recursion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SubSetSum1 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        int[] arr = {1, 2, 3};
        subsetSum(arr, 0, 0, ds);
        ds.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(ds);
    }

    static void subsetSum(int[] arr, int index, int sum, List<Integer> res) {
        if (index == arr.length) {
            res.add(sum);
            return;
        }

        //pick
        subsetSum(arr, index + 1, sum + arr[index], res);

        //not pick
        subsetSum(arr, index + 1, sum, res);

    }
}
