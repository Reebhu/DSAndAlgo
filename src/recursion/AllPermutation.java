package recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPermutation {
    public static void main(String[] args) {
        List<Integer> tempList = new ArrayList<>();
        List<List<Integer>> permutations = new ArrayList<>();
        int[] arr = {1, 2, 3};
        boolean[] map = new boolean[arr.length];
        permute(arr, map, tempList, permutations);
        System.out.println(permutations);
    }

    static void permute(int[] arr, boolean[] map, List<Integer> tempList, List<List<Integer>> permutations) {

        if (tempList.size() == arr.length) {
            permutations.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!map[i]) {
                map[i] = true;
                tempList.add(arr[i]);
                permute(arr, map, tempList, permutations);
                tempList.remove(tempList.size() - 1);
                map[i] = false;
            }


        }
    }
}
