package cc189.ch8;

import java.util.*;

/**
 * Created by xu_xt on 10/17/18.
 */
public class Q8_2 {
    public int numberOfPath(boolean[][] grid) {
        if (grid == null) {
            return 0;
        }
        int r = grid.length;
        if (grid[0] == null) {
            return 0;
        }
        int c = grid[0].length;
        if (r == 0 || c == 0) {
            return 0;
        }
        int[][] path = new int[r][c];
        // if top left is not accessible
        if (!grid[0][0]) {
            return 0;
        }
        path[0][0] = 1;
        // path[i][j] = path[i - 1][j] + path[i][j -1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j]) {
                    //within bound
                    if (i > 0) {
                        path[i][j] += path[i - 1][j];
                    }
                    if (j > 0) {
                        path[i][j] += path[i][j - 1];
                    }
                }
            }
        }
        return path[r - 1][c - 1];
    }

    public List<Point> getPath(boolean[][] grid) {
        List<Point> path = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();
        if (getPath(grid, 0, 0, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private boolean getPath(boolean[][] grid, int x, int y, List<Point> path, Set<Point> failedPoints) {
        int r = grid.length;
        int c = grid[0].length;
        if (x >= r || y >= c || !grid[x][y]) {
            return false;
        }
        Point point = new Point(x, y);
        if (failedPoints.contains(point)) {
            return false;
        }
        if (x == r - 1 && y == c - 1) {
            path.add(new Point(x, y));
            return true;
        }
        if (getPath(grid, x + 1, y, path, failedPoints) || getPath(grid, x, y + 1, path, failedPoints)) {
            path.add(point);
            return true;
        }
        failedPoints.add(point);
        return false;
    }

    public class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}