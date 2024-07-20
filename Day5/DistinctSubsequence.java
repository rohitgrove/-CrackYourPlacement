import java.util.Arrays;

public class DistinctSubsequence {
    public static int numDistinct(String s, String t) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solvedp(s, 0, t, 0, dp);
    }

    public static int solvedp(String s, int idx1, String t, int idx2, int dp[][]) {
        if (idx2 == t.length()) {
            return 1;
        }

        if (idx1 == s.length()) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        int take = 0;
        if (s.charAt(idx1) == t.charAt(idx2)) {
            take = solvedp(s, idx1 + 1, t, idx2 + 1, dp);
        }

        int nottake = solvedp(s, idx1 + 1, t, idx2, dp);
        dp[idx1][idx2] = nottake + take;
        return nottake + take;
    }

    public static int solverec(String s, int idx1, String t, int idx2) {
        if (idx2 == t.length()) {
            return 1;
        }

        if (idx1 == s.length()) {
            return 0;
        }

        int take = 0;
        if (s.charAt(idx1) == t.charAt(idx2)) {
            take = solverec(s, idx1 + 1, t, idx2 + 1);
        }

        int nottake = solverec(s, idx1 + 1, t, idx2);
        return nottake + take;
    }

    public static void main(String[] args) {
        String s1 = "rabbbit", t1 = "rabbit";
        System.out.println(numDistinct(s1, t1));
        String s2 = "babgbag", t2 = "bag";
        System.out.println(numDistinct(s2, t2));
    }
}
