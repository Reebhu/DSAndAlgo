import java.util.Arrays;

//Recursive with memoization
public class ZeroOneKnapsackProblem {
    static int[] memo;

    public static void main(String[] args) {
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int totalWeight = 50;
        memo = new int[weight.length];
        Arrays.fill(memo, -1);
        int value = findProfit(weight, profit, totalWeight, weight.length - 1);
        System.out.println(value);
    }

    private static int findProfit(int[] weight, int[] profit, int totalWeight, int index) {
        if (totalWeight == 0 || index == 0) {
            return 0;
        }
        if (weight[index] > totalWeight) {
            return findProfit(weight, profit, totalWeight, index - 1);
        }
        int value;
        if (memo[index - 1] != -1) {
            value = memo[index-1];
        } else {
            value = findProfit(weight, profit, totalWeight, index - 1);
            insertIntoMemo(value,index-1);
        }
        return Math.max(value + profit[index],
                value);
    }

    private static void insertIntoMemo(int value, int i) {
        memo[i]=value;
    }
}
