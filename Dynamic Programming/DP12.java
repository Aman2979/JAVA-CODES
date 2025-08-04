import java.util.Arrays;

public class DP12 {
    public static int recursion(int[][] matrix, int m, int i, int j) {
        if (j < 0 || j >= m) return (int) Math.pow(10, 9); // Very large number to avoid invalid paths
        if (i == 0) return matrix[0][j]; // Base case: first row

        int up = matrix[i][j] + recursion(matrix, m, i - 1, j);
        int leftDiagonal = matrix[i][j] + recursion(matrix, m, i - 1, j - 1);
        int rightDiagonal = matrix[i][j] + recursion(matrix, m, i - 1, j + 1);

        return Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

    public static int memorization(int[][] matrix, int [][]dp, int m, int i, int j) {
        if (j < 0 || j >= m) return (int) Math.pow(10, 9); // Very large number to avoid invalid paths
        if (i == 0) return matrix[0][j]; // Base case: first row

        if (dp[i][j] != -1) return dp[i][j];

        int up = matrix[i][j] + memorization(matrix, dp,m, i - 1, j);
        int leftDiagonal = matrix[i][j] + memorization(matrix, dp,m, i - 1, j - 1);
        int rightDiagonal = matrix[i][j] + memorization(matrix, dp,m, i - 1, j + 1);

        return dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

    public static int getMinPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int [][]dp = new int[n][m];
        for (int []row : dp){
            Arrays.fill(row, -1);
        }

        int mini = Integer.MAX_VALUE;

        // Try all possible starting points in the last row
        for (int j = 0; j < m; j++) {
            int ans = memorization(matrix, dp,m, n - 1, j);
            mini = Math.min(mini, ans);
        }

        return mini;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        System.out.println(getMinPathSum(matrix)); // Output: 13
    }
}
