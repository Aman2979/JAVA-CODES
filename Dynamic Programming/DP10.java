public class DP10 {
    public static int recursion(int[][] grid, int m, int n){
        if (m == 0 && n == 0) return grid[0][0];
        if (m < 0 || n < 0) return (int)1e9;
        int up = 0, left = 0;
        up = grid[m][n] + recursion(grid, m - 1, n);
        left = grid[m][n] + recursion(grid, m, n - 1);
        return Math.min(left,up);
    }

    public static int memorization(int[][] grid, int [][]dp, int m, int n){
        if (m == 0 && n == 0) return grid[0][0];
        if (m < 0 || n < 0) return (int)1e9;
        int up = 0, left = 0;
        if (dp[m][n] != -1) return dp[m][n];
        up = grid[m][n] + memorization(grid,dp, m - 1, n);
        left = grid[m][n] + memorization(grid,dp, m, n - 1);
        return dp[m][n] = Math.min(left,up);
    }

    public static int tabulation(int[][] grid, int [][]dp, int m, int n){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = grid[i][j];
                    if (i > 0)
                        up += dp[i - 1][j];
                    else {
                        up += (int) Math.pow(10, 9);
                    }

                    int left = grid[i][j];
                    if (j > 0)
                        left += dp[i][j - 1];
                    else {
                        left += (int) Math.pow(10, 9);
                    }

                // Store the minimum of the two possible paths
                dp[i][j] = Math.min(up, left);
            }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int [][]grid = {{1, 2, 3}, {4, 5, 6}};
        int m = grid.length;
        int n = grid[0].length;
        int [][]dp = new int[m][n];
//        for(int []row : dp){
//            Arrays.fill(row,-1);
//        }
        System.out.println(tabulation(grid,dp, m, n));
    }
}
