import java.util.Arrays;

public class DP13 {
    public static int recursion(int i, int j1, int j2, int n, int m, int [][]grid){ // (i) is same in every Case, but j1 & j2 not same.
        if (j1 < 0 || j1 >= m || j2<0|| j2>m) return -(int)1e9;
        if (i == n){
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        //Now Explore all the paths.
        int maxi = 0;
        for (int dj1 = -1; dj1 < 2; dj1++) {
            for (int dj2 = -1; dj2 < 2; dj2++) {
                if (j1 == j2) maxi = Math.max(maxi, grid[i][j1] + recursion(i+1, j1+dj1, j2 + dj2, n, m, grid));
                else maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + recursion(i+1, j1+dj1, j2 + dj2, n, m, grid));
            }
        }
        return maxi;
    }

    public static int memorization(int i, int j1, int j2, int n, int m, int [][]grid, int [][][]dp){ // (i) is same in every Case, but j1 & j2 not same.
        if (j1 < 0 || j1 >= m || j2<0|| j2>m) return -(int)1e9;
        if (i == n){
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        //Now Explore all the paths.
        int maxi = 0;
        for (int dj1 = -1; dj1 < 2; dj1++) {
            for (int dj2 = -1; dj2 < 2; dj2++) {
                if (j1 == j2) maxi = Math.max(maxi, grid[i][j1] + memorization(i+1, j1+dj1, j2 + dj2, n, m, grid, dp));
                else maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + memorization(i+1, j1+dj1, j2 + dj2, n, m, grid, dp));
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    public static int tabulation(int n, int m, int [][]grid, int [][][]dp){ // (i) is same in every Case, but j1 & j2 not same.
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m;j2++) {
                if (j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = 0;
                    for (int dj1 = -1; dj1 < 2; dj1++) {
                        for (int dj2 = -1; dj2 < 2; dj2++) {
                            int value = 0;
                            if (j1 == j2) value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if (j1+dj1 >= 0 && j1+dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            }
                            else{
                                value += -(int)1e9;
                            }
                            maxi = Math.max(value, maxi);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }

    public static int spaceOptimization(int n, int m, int [][]grid, int [][]front){ // (i) is same in every Case, but j1 & j2 not same.
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m;j2++) {
                if (j1 == j2) front[j1][j2] = grid[n-1][j1];
                else front[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for (int i = n-2; i >= 0; i--) {
            int[][] curr = new int[m][m];  // 🟢 new array each time
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MAX_VALUE;
                    for (int dj1 = -1; dj1 < 2; dj1++) {
                        for (int dj2 = -1; dj2 < 2; dj2++) {
                            int value = 0;
                            if (j1 == j2) value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if (j1+dj1 >= 0 && j1+dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                value += front[j1 + dj1][j2 + dj2];
                            }
                            else{
                                value += -(int)1e9;
                            }
                            maxi = Math.max(value, maxi);
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            front = curr;
        }
        return front[0][m-1];
    }
    public static void main(String[] args) {
        int [][]grid = {{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};
        int n = grid.length;
        int m = grid[0].length;
        int [][]front = new int[m][m];
        int [][] curr = new int[m][m];
        int [][][]dp = new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], 0);
            }
        }
        System.out.println(spaceOptimization(n, m, grid, front));
    }
}
