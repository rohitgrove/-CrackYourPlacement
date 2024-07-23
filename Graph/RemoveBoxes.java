import java.util.Arrays;

public class RemoveBoxes {
    public static int solve(int l, int r, int count, int[] boxes, int[][][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][count] != -1) {
            return dp[l][r][count];
        }

        int i = l;
        int cnt = count;
        // Skip over the boxes with the same color
        while (i + 1 <= r && boxes[i + 1] == boxes[l]) {
            i++;
            cnt++;
        }
        
        // Case 1: Remove all boxes of the same color together
        int basic = (cnt + 1) * (cnt + 1) + solve(i + 1, r, 0, boxes, dp);

        // Case 2: Try to merge boxes with the same color that are not consecutive
        int lalach = 0;
        for (int m = i + 1; m <= r; m++) {
            if (boxes[m] == boxes[l]) {
                lalach = Math.max(lalach, solve(m, r, cnt + 1, boxes, dp) + solve(i + 1, m - 1, 0, boxes, dp));
            }
        }

        return dp[l][r][count] = Math.max(basic, lalach);
    }

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return solve(0, n - 1, 0, boxes, dp);
    }
}