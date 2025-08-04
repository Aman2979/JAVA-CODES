import java.util.Arrays;

public class DP8 {
    public static int recursion(int m, int n) {
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        int up = recursion(m-1, n);
        int left = recursion(m, n-1);
        return up + left;
    }

    public static int memorization(int [][]dp, int m, int n) {
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];
        int up = memorization(dp,m-1, n);
        int left = memorization(dp, m, n-1);
        return dp[m][n] = up + left;
    }

    public static int tabulation(int [][]dp, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0, left = 0;
                if (i > 0){
                    up = dp[i-1][j];
                }
                if(j > 0){
                    left = dp[i][j-1];
                }
                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int [][]dp = new int[m][n];
        //This to fill in dp, another values.
        for(int []row : dp) Arrays.fill(row, -1);
        System.out.println(tabulation(dp,m, n));
    }
}
