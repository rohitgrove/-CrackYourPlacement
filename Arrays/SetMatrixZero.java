public class SetMatrixZero {
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] isOriginalZero = new boolean[rows][cols];

        // First pass: record the position of original zeros in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    isOriginalZero[i][j] = true;
                }
            }
        }

        // Second pass: set the corresponding rows and columns to zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isOriginalZero[i][j]) {
                    // Set the entire row to zero
                    for (int c = 0; c < cols; c++) {
                        matrix[i][c] = 0;
                    }
                    // Set the entire column to zero
                    for (int r = 0; r < rows; r++) {
                        matrix[r][j] = 0;
                    }
                }
            }
        }
    }

    public static void printArr(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int matrix1[][] = { { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } };

        int matrix2[][] = { { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 } };

        System.out.println("Before set Zero");
        System.out.println("Matrix 1");
        printArr(matrix1);
        System.out.println("Matrix 2");
        printArr(matrix2);

        setZeroes(matrix1);
        setZeroes(matrix2);

        System.out.println("After set Zero");
        System.out.println("Matrix 1");
        printArr(matrix1);
        System.out.println("Matrix 2");
        printArr(matrix2);

    }
}
