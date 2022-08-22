import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class NextPermutationNaive {
    public static void main(String[] args) {
        int a[] = { 2, 3,1};
        List<Integer> outputList = getNextPermutation(a);
        System.out.println(outputList);
    }

    private static List<Integer> getNextPermutation(int[] a) {
        List<List<Integer>> permutationList = getAllPermutations(a);
        permutationList.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return NextPermutationNaive.compare(o1, o2);
            }
        });
        List<Integer> inputList = new ArrayList<>();
        List<Integer> outputList = new ArrayList<>();
        for (int i : a) {
            inputList.add(i);
        }

        for (List<Integer> list : permutationList) {
            if (compare(list, inputList) == 1) {
                outputList.addAll(list);
                break;
            }
        }
        if (outputList.size() == 0) {
            outputList.addAll(permutationList.get(0));
        }
        return outputList;
    }

    private static List<List<Integer>> getAllPermutations(int[] a) {
        List<List<Integer>> permutationList = new ArrayList<>();
        recurssivePermute(a, 0, permutationList);
        return permutationList;
    }

    private static void recurssivePermute(int a[], int index, List<List<Integer>> permutationList) {
        if (index == a.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : a) {
                list.add(i);
            }
            permutationList.add(list);
        }
        for (int i = index; i < a.length; i++) {
            swap(a, i, index);
            recurssivePermute(a, index + 1, permutationList);
            swap(a, i, index);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static int compare(List<Integer> o1, List<Integer> o2) {
        int value = 0;
        for (int i = 0; i < o1.size(); i++) {
            value = o1.get(i).compareTo(o2.get(i));
            if (value != 0) {
                return value;
            }
        }
        return value;
    }
}
