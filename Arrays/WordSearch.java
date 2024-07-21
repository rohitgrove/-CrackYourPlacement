public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (solve(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean solve(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean found = solve(board, word, i + 1, j, index + 1) ||
                solve(board, word, i, j + 1, index + 1) ||
                solve(board, word, i - 1, j, index + 1) ||
                solve(board, word, i, j - 1, index + 1);

        board[i][j] = temp;
        return found;
    }

    public static void main(String[] args) {
        char board1[][] = { { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' } };
        String word1 = "ABCCED";

        System.out.println(exist(board1, word1));

        char board2[][] = { { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' } };
        String word2 = "SEE";

        System.out.println(exist(board2, word2));

        char board3[][] = { { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' } };
        String word3 = "ABCB";

        System.out.println(exist(board3, word3));
    }
}
