package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//Won't return the list but will return the size of lis.
public class LISBinarySearch {
    public static void main(String[] args) {
        //int[] arr = {0, 1, 0, 3, 2, 3};
        //int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] arr = {1, 7, 8, 4, 5, 6, -1, 9};
        System.out.println(findLIS(arr));
//        System.out.println(findNextLargest(18, Arrays.stream(arr).boxed().collect(Collectors.toList()), 0, arr.length - 1));
    }

    private static int findLIS(int[] arr) {
        List<Integer> lis = new ArrayList<>();
        int j = 0;
        lis.add(arr[0]);
        for (int i : arr) {
            if (i > lis.get(j)) {
                lis.add(i);
                j++;
                continue;
            }
            int ind = Collections.binarySearch(lis, i);
            if (ind >= 0) {
                lis.remove(ind);
                lis.add(ind, i);
            }
            else {
                ind = Math.abs(ind) - 1;
                lis.remove(ind);
                lis.add(ind, i);
            }
        }
        return lis.size();
    }
}
