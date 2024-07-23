public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        int oneCount = 0;
        int zeroCount = 0;

        for (int i = 1; i < strs.length + 1; ++i) {
            String str = strs[i - 1];
            int[] count = count(str);

            zeroCount += count[0];
            oneCount += count[1];
            for (int j = 0; j < m + 1; ++j) {
                for (int k = 0; k < n + 1; ++k) {
                    if (j == 0 && k == 0) {

                        dp[i][j][k] = 0;
                    } else if (zeroCount <= j && oneCount <= k) {

                        dp[i][j][k] = i;
                    } else if (j >= count[0] && k >= count[1]) {

                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - count[0]][k - count[1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        return dp[strs.length][m][n];

    }

    private int[] count(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            if (c == '0')
                res[0]++;
            else
                res[1]++;
        }

        return res;
    }
}