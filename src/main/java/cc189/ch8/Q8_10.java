package cc189.ch8;

import java.util.*;

/**
 * Created by xu_xt on 10/19/18.
 */
public class Q8_10 {
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, -1, -1};
    public void fillColor(int[][] grid, int i, int j, int color) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        grid[i][j] = color;
        while(!q.isEmpty()) {
            Point p = q.poll();
            grid[p.x][p.y] = color;
            for(int k = 0; k < 4; k++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (isValid(x, y, grid, color)) {
                    q.add(new Point(x, y));
                    grid[x][y] = color;
                }
            }
        }
    }
    private boolean isValid(int x, int y, int[][] grid, int color) {
        return x >=0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != color;
    }
    private class Point {
        int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
