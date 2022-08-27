import java.util.ArrayList;
import java.util.List;

public class SubSetSum2Optimal {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        int[] arr = {1, 2, 2};
        subsetSum(arr, 0, ds, subsets);
        System.out.println(subsets);
    }

    static void subsetSum(int[] arr, int index, List<Integer> res, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(res));

        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1]) continue;
            res.add(arr[i]);
            subsetSum(arr, i + 1, res, subsets);
            res.remove(res.size() - 1);
        }

    }
}
