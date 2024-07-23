import java.util.Arrays;

public class BuyAndSellStocks {
    public int maxProfit(int k, int[] prices) {
        int dp[][] = new int[prices.length][2 * k];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveMemo(0, 0, k, prices, dp);
    }

    public static int solveMemo(int index, int opreationNo, int k, int prices[], int dp[][]) {
        if (index == prices.length) {
            return 0;
        }

        if (opreationNo == 2 * k) {
            return 0;
        }

        if (dp[index][opreationNo] != -1) {
            return dp[index][opreationNo];
        }

        int profit = 0;
        if (opreationNo % 2 == 0) {
            int buyKaro = ~(prices[index] - 1) + solveMemo(index + 1, opreationNo + 1, k, prices, dp);
            int buyMatKaro = solveMemo(index + 1, opreationNo, k, prices, dp);
            profit = Math.max(buyKaro, buyMatKaro);
        } else {
            int sellKardo = prices[index] + solveMemo(index + 1, opreationNo + 1, k, prices, dp);
            int sellMAtKaro = solveMemo(index + 1, opreationNo, k, prices, dp);
            profit = Math.max(sellMAtKaro, sellKardo);
        }
        return dp[index][opreationNo] = profit;
    }

    public static int solveTabu(int prices[], int k) {
        int dp[][] = new int[prices.length + 1][2 * k + 1];
        int n = prices.length;
        for (int index = n - 1; index >= 0; index--) {
            for (int opreationNo = 0; opreationNo < 2 * k; opreationNo++) {
                int profit = 0;
                if (opreationNo % 2 == 0) {
                    int buyKaro = ~(prices[index] - 1) + dp[index + 1][opreationNo + 1];
                    int buyMatKaro = dp[index + 1][opreationNo];
                    profit = Math.max(buyKaro, buyMatKaro);
                } else {
                    int sellKardo = prices[index] + dp[index + 1][opreationNo + 1];
                    int sellMAtKaro = dp[index + 1][opreationNo];
                    profit = Math.max(sellMAtKaro, sellKardo);
                }
                dp[index][opreationNo] = profit;
            }
        }
        return dp[0][0];
    }

    public static int solveSO(int prices[], int k) {
        int curr[] = new int[2 * k + 1];
        int next[] = new int[2 * k + 1];
        int n = prices.length;
        for (int index = n - 1; index >= 0; index--) {
            for (int opreationNo = 0; opreationNo < 2 * k; opreationNo++) {
                int profit = 0;
                if (opreationNo % 2 == 0) {
                    int buyKaro = ~(prices[index] - 1) + next[opreationNo + 1];
                    int buyMatKaro = next[opreationNo];
                    profit = Math.max(buyKaro, buyMatKaro);
                } else {
                    int sellKardo = prices[index] + next[opreationNo + 1];
                    int sellMAtKaro = next[opreationNo];
                    profit = Math.max(sellMAtKaro, sellKardo);
                }
                curr[opreationNo] = profit;
            }
            next = curr;
        }
        return next[0];
    }
}