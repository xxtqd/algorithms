package cc189.ch1;

/**
 * Created by xu_xt on 10/2/18.
 */
public class Q1_7 {
    public void rotateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        int n = matrix.length;
        for (int x = 0; x < n / 2; x++) {
            for (int y = x; y < (n + 1) / 2; y++) {
                int temp = matrix[x][y];
                // anti-clockwise
                matrix[x][y] = matrix[y][n - 1 - x];
                matrix[y][n - 1 - x] = matrix[n - 1 - x][n - 1 - y];
                matrix[n - 1 - x][n - 1 - y] = matrix[n - 1 - y][x];
                matrix[n - 1 - y][x] = temp;
                // clockwise
                matrix[x][y] = matrix[n - 1 - y][x];
                matrix[n - 1 - y][x] = matrix[n - 1 - x][n - 1 - y];
                matrix[n - 1 - x][n - 1 - y] = matrix[y][n - 1 - x];
                matrix[y][n - 1 - x] = temp;
            }
        }

    }
}