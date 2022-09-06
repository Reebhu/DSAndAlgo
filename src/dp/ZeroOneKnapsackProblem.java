package dp;

import java.util.Arrays;

//Recursive with memoization
public class ZeroOneKnapsackProblem {
    static int[][] memo; //Since there are two changing parameters

    public static void main(String[] args) {
        int[] profit = {60, 100, 100, 120};
        int[] weight = {10, 20, 20, 30};
        int totalWeight = 50;
        memo = new int[weight.length][totalWeight + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        int value = findProfit(weight, profit, totalWeight, weight.length - 1);
        System.out.println(value);
        Arrays.stream(memo).forEach(a -> Arrays.stream(a).forEach(System.out::println));
    }

    private static int findProfit(int[] weight, int[] profit, int totalWeight, int index) {
        if (totalWeight == 0 || index < 0) {
            return 0;
        }

        if (memo[index][totalWeight] != -1)
            return memo[index][totalWeight];
        //Not take
        if (weight[index] > totalWeight) {
            return memo[index][totalWeight] = findProfit(weight, profit, totalWeight, index - 1);
        }
        //Take
        int value1 = findProfit(weight, profit, totalWeight - weight[index], index - 1) + profit[index];
        int value2 = findProfit(weight, profit, totalWeight, index - 1);
        memo[index][totalWeight] = Math.max(value1, value2
        );
        return memo[index][totalWeight];
    }
}
