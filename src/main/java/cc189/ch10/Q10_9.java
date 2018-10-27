package cc189.ch10;

/**
 * Created by xu_xt on 10/24/18.
 */
public class Q10_9 {
    public Point searchMatrix(int[][] sortedArray, int target) {
        if (sortedArray == null || sortedArray.length == 0 || sortedArray[0].length == 0) {
            return new Point(-1, -1);
        }
        int m = sortedArray.length;
        int n = sortedArray[0].length;
        int r = m - 1, c = 0; // start from bottom left
        while (c < n && r >= 0) {
            if (target == sortedArray[r][c]) {
                return new Point(r, c);
            } else if (target > sortedArray[r][c]) {
                c++;
            } else {
                r--;
            }
        }
        return new Point(-1, -1);
    }
    class Point {
        int r, c;
        Point (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
