package dp;

/**
 * Created by xxu on 1/3/2018.
 */
public class StoneGameII {
    /*
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame2(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        int[][] sums = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if (i == j){
                    sums[i][j]  =  A[i];
                    dp[i][j] = 0;
                } else {
                    if (i < j){
                        sums[i][j]  = sums[i][j - 1] + A[j];
                    }
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if (sums[i][j] == 0){
                    if ( j == 0) {
                        sums[i][j] = sums[i][n - 1] + A[j];
                    } else {
                        sums[i][j] = sums[i][j - 1] + A[j];
                    }
                }
            }
        }
        int min = 0;
        for (int i = 0; i < n; i++){
            for (int j = n - 1; j >= 0; j--){
                min = Math.min(min, search(i, j, sums, dp));
            }
        }
        return min;
    }

    private int search(int start, int end, int[][] sums, int[][] dp){
        int n = sums.length;
        if (dp[start % n][end % n] != Integer.MAX_VALUE) {
            return dp[start % n][end % n];
        }
        int count = 0;
        if (start > end) {
            count = n - start + end + 1;
        } else {
            count = end - start + 1;
        }
        int left, right;
        for (int k = 0; k < count; k++){
            left = search(start, start + k, sums, dp);
            right = search (start + k + 1, end, sums, dp);
            dp[start%n][end%n] = Math.min(dp[start%n][end%n], left + right + sums[start%n][end%n]);
        }
        return dp[start%n][end%n];
    }
    public static void main(String[] args) {
        StoneGameII stoneGame = new StoneGameII();
        System.out.println(stoneGame.stoneGame2(new int[]{1,1,4,4}));
    }
}
