import java.util.Arrays;

public class WordWrap {
    public static int solve(int[] arr, int i, int rem, int k, int[][] dp) {
        if (i == arr.length)
            return 0;

        if (dp[i][rem + 1] != -1)
            return dp[i][rem + 1];

        int ans;
        if (rem < arr[i]) {
            ans = (rem + 1) * (rem + 1) + solve(arr, i + 1, k - arr[i] - 1, k, dp);
        } else {
            int choice1 = (rem + 1) * (rem + 1) + solve(arr, i + 1, k - arr[i] - 1, k, dp);
            int choice2 = solve(arr, i + 1, rem - arr[i] - 1, k, dp);
            ans = Math.min(choice1, choice2);
        }
        return dp[i][rem + 1] = ans;
    }

    public static int solveWordWrap(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(nums, 1, k - nums[0] - 1, k, dp);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 5 };
        int k = 6;
        System.out.println(solveWordWrap(nums, k));
    }
}
