public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    public static boolean isSafe(int k, int row, int col, char board[][]) {
        for (int i = 0; i <= 8; i++) {
            if (board[i][col] == k) {
                return false;
            }
        }

        // col
        for (int j = 0; j <= 8; j++) {
            if (board[row][j] == k) {
                return false;
            }
        }

        // gird
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        // 3x3 grid
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solve(char board[][]) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // empty cell
                if (board[row][col] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        if (isSafe(k + '0', row, col, board)) {
                            board[row][col] = Character.forDigit(k, 10);
                            boolean aageKaSolution = solve(board);
                            if (aageKaSolution == true) {
                                return true;
                            } else {
                                // Bacltracking
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public static void printSodoku(int sudoku[][]) {
        System.out.println("Start");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("End");
    }
    class Solution {
        public void solveSudoku(char[][] board) {
            solve(board);
        }
        public boolean isSafe(int k, int row, int col, char board[][]) {
             for (int i = 0; i <= 8; i++) {
                if (board[i][col] == k) {
                    return false;
                }
            }
    
            // col
            for (int j = 0; j <= 8; j++) {
                if (board[row][j] == k) {
                    return false;
                }
            }
    
            // gird
            int sr = (row / 3) * 3;
            int sc = (col / 3) * 3;
            // 3x3 grid
            for (int i = sr; i < sr + 3; i++) {
                for (int j = sc; j < sc + 3; j++) {
                    if (board[i][j] == k) {
                        return false;
                    }
                }
            }
    
            return true;
        }
        public boolean solve(char board[][]) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    // empty cell
                    if (board[row][col] == '.') {
                        for (int k = 1; k <= 9; k++) {
                            if (isSafe(k + '0', row, col, board)) {
                                board[row][col] = Character.forDigit(k, 10);
                                boolean aageKaSolution = solve(board);
                                if (aageKaSolution == true) {
                                    return true;
                                } else {
                                    // Bacltracking
                                    board[row][col] = '.';
                                }
                            }
                        }
                        return false;
                    }
                }
            }
    
            return true;
        }
    }
}
