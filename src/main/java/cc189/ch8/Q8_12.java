package cc189.ch8;

import java.util.*;

/**
 * Created by xu_xt on 10/19/18.
 */
public class Q8_12 {
    public void nQueens(int n) {
        if (n == 0) {
            return;
        }
        char[][] grid = new char[n][n];
        for (char[] t : grid) {
            Arrays.fill(t, '-');
        }
        helper(grid, new ArrayList<>());
    }
    private void helper(char[][] grid, List<Integer> colIndexList) {
        if (colIndexList.size() == grid.length){
            System.out.println("Solution:");
            for (char[] chars : grid) {
                System.out.println(new String(chars));
            }
            return;
        }
        for (int col = 0; col < grid.length; col++) {
            if (isColValid(colIndexList, grid, col)) {
                colIndexList.add(col);
                grid[colIndexList.size() - 1][col] = 'Q';
                helper(grid, colIndexList);
                grid[colIndexList.size() - 1][col] = '-';
                colIndexList.remove(colIndexList.size() - 1);
            }
        }
    }

    private boolean isColValid(List<Integer> colIndexList, char[][] grid, int col) {
        for (int row = 0; row < colIndexList.size(); row++) {
            if (grid[row][col] == 'Q') {
                return false;
            }
            int colIndex = colIndexList.get(row);
            if (Math.abs(row - colIndexList.size()) == Math.abs(colIndex - col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q8_12 q = new Q8_12();
        q.nQueens(8);
    }
}
