import java.util.Arrays;

public class CoinChange {
    public int solve(int[] coins, int amount) {
        // Base case
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            // current coin ko sir tabhi use karenge
            // jab uski value <= amount hogi
            if (coin <= amount) {
                int recAns = solve(coins, amount - coin);
                if (recAns != Integer.MAX_VALUE) {
                    mini = Math.min(mini, 1 + recAns);
                }
            }
        }
        return mini;
    }

    public int coinChange(int[] coins, int amount) {
        int ans = solve(coins, amount);
        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }

    public int solveTabu(int coins[], int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // fill with max value to avoid overflows
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // i m trying to solve for every figure from 1 to amount
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];
    }

}