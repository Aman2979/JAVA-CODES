import java.util.*;

public class DP9 {
    public static int recursion(int[][] obstacleGrid,int m , int n) {
        if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1) return 0;
        if (m == 0 && n == 0){
            return 1;
        }
        if (m < 0 || n < 0) return 0;
        int up = 0, left = 0;
        up = recursion(obstacleGrid, m - 1, n);
        left = recursion(obstacleGrid,m, n-1);
        return up + left;
    }

    public static int memorization(int[][] obstacleGrid, int [][]dp, int m , int n) {
        if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1) return 0;
        if (m == 0 && n == 0){
            return 1;
        }
        if (m < 0 || n < 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];
        int up = 0, left = 0;
        up = memorization(obstacleGrid, dp,m - 1, n);
        left = memorization(obstacleGrid,dp, m, n-1);
        return dp[m][n] = up + left;
    }

    public static int tabulation(int[][] obstacleGrid, int [][]dp, int m , int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = 0, left = 0;
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }else {
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int [][]obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]dp = new int[m][n];
        for(int []row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(tabulation(obstacleGrid, dp, m, n));
    }
}
