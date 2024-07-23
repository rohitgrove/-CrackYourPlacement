import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public int solveRec(int nums[], int curr, int prev) {
        if (curr == nums.length) {
            return 0;
        }

        int pick = 0;
        if (prev == -1 || nums[curr] > nums[prev]) {
            pick = 1 + solveRec(nums, curr + 1, curr);
        }

        int notPick = solveRec(nums, curr + 1, prev);
        return Math.max(pick, notPick);
    }

    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveDP(nums.length, nums, 0, -1, dp);
    }

    public int solveDP(int n, int arr[], int curr, int prev, int dp[][]) {
        // base case
        if (curr == n) {
            return 0;
        }

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        // include
        int pick = 0;
        if (prev == -1 || arr[curr] > arr[prev]) {
            pick = 1 + solveDP(n, arr, curr + 1, curr, dp);
        }

        int notPick = 0 + solveDP(n, arr, curr + 1, prev, dp);

        dp[curr][prev + 1] = Math.max(pick, notPick);
        return dp[curr][prev + 1];
    }
}