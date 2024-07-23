import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveDP(0, 0, text1, text2, dp);
    }

    public static int solve(int idx1, int idx2, String text1, String text2) {
        if (idx1 == text1.length() || idx2 == text2.length()) {
            return 0;
        }

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            return 1 + solve(idx1 + 1, idx2 + 1, text1, text2);
        } else {
            int sp1 = solve(idx1 + 1, idx2, text1, text2);
            int sp2 = solve(idx1, idx2 + 1, text1, text2);
            return Math.max(sp1, sp2);
        }
    }

    public static int solveDP(int idx1, int idx2, String text1, String text2, int dp[][]) {
        if (idx1 == text1.length() || idx2 == text2.length()) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            dp[idx1][idx2] = 1 + solveDP(idx1 + 1, idx2 + 1, text1, text2, dp);
            return dp[idx1][idx2];
        } else {
            int sp1 = solveDP(idx1 + 1, idx2, text1, text2, dp);
            int sp2 = solveDP(idx1, idx2 + 1, text1, text2, dp);
            dp[idx1][idx2] = Math.max(sp1, sp2);
            return dp[idx1][idx2];
        }
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
