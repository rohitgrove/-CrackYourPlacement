import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 1, prices, dp);
    }

    public static int solve(int idx, int buy, int[] prices,int dp[][]) {
        if (idx == prices.length) {
            return 0;
        }

        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        int profit = 0;
        if (buy == 1) {
            int buyKarlo = ~(prices[idx] - 1) + solve(idx + 1, 0, prices, dp);
            int buyMatKaro = solve(idx + 1, 1, prices, dp);
            profit = Math.max(buyKarlo, buyMatKaro);
        } else {
            int sellKardo = prices[idx] + solve(idx, 1, prices, dp);
            int sellMatKaro = solve(idx + 1, 0, prices, dp);
            profit = Math.max(sellKardo, sellMatKaro);
        }

        dp[idx][buy] = profit;
        return profit;
    }

    public static void main(String[] args) {
        int prices1[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices1));
        int prices2[] = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices2));
        int prices3[] = { 1, 2, 3, 4, 5 };
        System.out.println(maxProfit(prices3));
    }
}
