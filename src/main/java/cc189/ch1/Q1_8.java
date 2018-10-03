package cc189.ch1;

/**
 * Created by xu_xt on 10/2/18.
 */
// O(n^2) time O(1) space
public class Q1_8 {
    public void zeroMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // use the first row and first column to store rows and columns that should be 0
        // need to store if the first row has a zero
        boolean firstRowZero = false;
        for (int i = 0; i < n; i++) {
            int num = matrix[0][i];
            if (num == 0) {
                firstRowZero = true;
                break;
            }
        }
        // same logic for columns
        boolean firstColumnZero = false;
        for (int i = 0; i < m; i++) {
            int num = matrix[i][0];
            if (num == 0) {
                firstColumnZero = true;
                break;
            }
        }
        // check numbers in the middle and set value in first row and first column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // set zeros
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstColumnZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Q1_8 q = new Q1_8();
        int[][] matrix = {{1,2,0,4}, {2,5,6,7}, {1,4,6,0}};
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num);
            }
            System.out.println();
        }
        q.zeroMatrix(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
