public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int origColor = image[sr][sc];

        if (newColor == origColor)
            return image;

        solve(image, sr, sc, origColor, newColor);
        return image;
    }

    public void solve(int[][] image, int row, int col, int origColor, int newColor) {
        if (row < 0 || col < 0 || row == image.length || col == image[0].length || image[row][col] != origColor) {
            return;
        }

        image[row][col] = newColor;

        solve(image, row - 1, col, origColor, newColor);
        solve(image, row + 1, col, origColor, newColor);
        solve(image, row, col + 1, origColor, newColor);
        solve(image, row, col - 1, origColor, newColor);
    }
}