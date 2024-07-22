public class UniquePath3 {
    public static int noObCount;
    public static int m, n;
    public static int ans = 0;
    public static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void solve(int[][] grid, int count, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == -1) {
            return;
        }
        if (grid[i][j] == 2) {
            if (count == noObCount) {
                ans++;
            }
            return;
        }
        grid[i][j] = -1;
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            solve(grid, count + 1, newI, newJ);
        }
        grid[i][j] = 0;
    }

    public static int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        noObCount = 0;
        int startX = 0, startY = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    noObCount++;
                }
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        noObCount += 1;
        solve(grid, 0, startX, startY);
        return ans;
    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 2, -1 } };
        System.out.println(uniquePathsIII(grid));
    }
}
