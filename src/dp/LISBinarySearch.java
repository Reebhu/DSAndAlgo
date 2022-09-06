package dp;

import java.util.ArrayList;
import java.util.List;


//Won't return the list but will return the size of lis.
public class LISBinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 2, 3};
        //int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(findLIS(arr));
//        System.out.println(findNextLargest(18, Arrays.stream(arr).boxed().collect(Collectors.toList()), 0, arr.length - 1));
    }

    private static int findLIS(int[] arr) {
        List<Integer> lis = new ArrayList<>();
        for (int i : arr) {
            if (lis.isEmpty()) {
                lis.add(i);
            } else {
                int index = findNextLargest(i, lis, 0, lis.size() - 1);
                if (i <= lis.get(index)) {
                    lis.remove(index);
                    lis.add(index, i);
                } else {
                    lis.add(i);
                }
            }
        }
        return lis.size();
    }

    private static int findNextLargest(int i, List<Integer> array, int start, int end) {
        int mid = (start + end) / 2;
        if (start >= end) {
            return mid;
        } else if (i > array.get(mid)) {
            return findNextLargest(i, array, mid + 1, end);
        } else if (i < array.get(mid)) {
            return findNextLargest(i, array, start, mid - 1);
        }
        return mid;
    }

}
