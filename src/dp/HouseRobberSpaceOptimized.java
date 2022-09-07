package dp;

public class HouseRobberSpaceOptimized {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 3, 100};
        int n = arr.length;
        int[] dp = new int[n];
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int n = nums.length;
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        return Math.max(solve(0, n - 2, nums), solve(1, n - 1, nums));
    }

    private static int solve(int l, int n, int[] arr) {
        int prevPrev = arr[l];
        int prev = Math.max(arr[l + 1], prevPrev);
        int current = 0;
        for (int i = l + 2; i <= n; i++) {

            current = Math.max(prev, arr[i] + prevPrev);
            prevPrev = prev;
            prev = current;
        }
        return prev;
    }

}
