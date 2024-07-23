import java.util.Arrays;

public class ClimbingStairs {
    public int solveRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return solveRec(n - 1) + solveRec(n - 2);
    }

    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solveDP(n, dp);
    }

    public int solveDP(int n, int dp[]) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solveDP(n - 1, dp) + solveDP(n - 2, dp);
        return dp[n];
    }

    public int SOtabulation(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}