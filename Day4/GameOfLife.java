public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[] directions = { -1, 0, 1 };
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = 0;
                for (int dx : directions) {
                    for (int dy : directions) {
                        if (dx == 0 && dy == 0)
                            continue;
                        int neighborX = i + dx;
                        int neighborY = j + dy;
                        if (neighborX >= 0 && neighborX < rows && neighborY >= 0 && neighborY < cols &&
                                (board[neighborX][neighborY] == 1 || board[neighborX][neighborY] == 2)) {
                            liveNeighbors++;
                        }
                    }
                }
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2; // 1 -> 0, mark as dead
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = -1; // 0 -> 1, mark as live
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void printArr(int[][] board) {
        System.out.println("Board Of Game Of Life");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int board[][] = { { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 } };

        printArr(board);
        gameOfLife(board);
        printArr(board);

        int board1[][] = { { 1, 1 },
                { 1, 0 } };
        printArr(board1);
        gameOfLife(board1);
        printArr(board1);
    }
}
