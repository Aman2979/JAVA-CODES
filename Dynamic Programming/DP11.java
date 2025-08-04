import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP11 {
    public static int recursion(List<List<Integer>> triangle, int n, int m, int i, int j){
        // Base Case.
        if (i == n) return triangle.get(i).get(j);

        int down = triangle.get(i).get(j) + recursion(triangle, n, m, i+1, j);
        int diagonal = triangle.get(i).get(j) + recursion(triangle, n, m, i+1, j+1);
        return Math.min(down, diagonal);
    }

    public static int memorization(List<List<Integer>> triangle, int n, int m, int i, int j, int [][]dp){
        // Base Case.
        if (i == n) return triangle.get(i).get(j);

        if (dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j) + memorization(triangle, n, m, i+1, j, dp);
        int diagonal = triangle.get(i).get(j) + memorization(triangle, n, m, i+1, j+1, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }

    public static int tabulation(List<List<Integer>> triangle, int n, int m, int i, int j, int [][]dp){
        // Base Case.
        for (int k = 0; k < n; k++) {
            dp[n-1][k] = triangle.get(n-1).get(k);
        }


        // Loops
        for (int k = n-2; k >= 0; k--) {
            for (int l = 0; l <= k; l++) {
                int down = triangle.get(k).get(l) + dp[k+1][l];
                int diagonal = triangle.get(k).get(l) + dp[k+1][l+1];
                dp[k][l] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }
    public static int helperFunction(List<List<Integer>> triangle){
        int n = triangle.size();
        int m = triangle.get(0).size();
        int [][]dp = new int[n][n];
        for(int []row : dp){
            Arrays.fill(row, -1);
        }
        return tabulation(triangle, n, m, 0, 0, dp);
    }
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(helperFunction(triangle));
    }
}
