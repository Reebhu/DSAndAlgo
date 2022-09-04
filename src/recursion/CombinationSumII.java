package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(arr, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCandidates(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    static void findCandidates(int[] arr, int ind, int target, List<Integer> ds, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            // Compare with the previous index,
            if (i > ind && arr[i] == arr[i - 1])
                continue; // Comparing with "ind" might cause repetition as ind might be
            //different index.

            if (arr[i] > target) continue;
            ds.add(arr[i]);
            findCandidates(arr, i + 1, target - arr[i], ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}
