import java.util.Arrays;

public class DP23 {
    public static int recursion(int []val, int []wt, int W, int index){
        // Base Case
        if (index == 0){
            return (W/wt[0]) * val[0];
        }

        int notTake = recursion(val, wt, W, index-1); // 0 + recursion(val, wt, W, index-1);
        int take = Integer.MIN_VALUE;
        if (wt[index] <= W){
            take = val[index] + recursion(val, wt, W - wt[index], index);
        }
        return Math.max(notTake, take);
    }

    public static int memorization(int []val, int []wt, int W, int index, int [][]dp){
        // Base Case
        if (index == 0){
            return (W/wt[0]) * val[0];
        }

        if (dp[index][W] != -1) return dp[index][W];
        int notTake = memorization(val, wt, W, index-1, dp);
        int take = Integer.MIN_VALUE;
        if (wt[index] <= W){
            take = val[index] + memorization(val, wt, W - wt[index], index, dp);
        }
        return dp[index][W] = Math.max(notTake, take);
    }

    public static int tabulation(int[] val, int[] wt, int w, int ind, int[][] dp) {
        // Base case initialization
        for (int W = 0; W <= w; W++) {
            dp[0][W] = (W/wt[0]) * val[0];
        }

        for (int index = 1; index < ind; index++) {
            for (int W = 0; W <= w; W++) {
                int notTake = dp[index - 1][W];
                int take = Integer.MIN_VALUE;
                if (wt[index] <= W) {
                    take = val[index] + dp[index][W - wt[index]];
                }
                dp[index][W] = Math.max(notTake, take);
            }
        }

        return dp[ind - 1][w];
    }

    public static int helperFunction(int []val, int []wt, int W){
        int n = val.length;
        int [][]dp = new int[n][W+1];
        for(int []row : dp){
            Arrays.fill(row, 0);
        }
        return tabulation(val, wt, W, n, dp);
    }
    public static void main(String[] args) {
        int []val = {30, 40, 60};
        int []wt = {3, 2, 5};
        int W = 6;
        System.out.println(helperFunction(val, wt, W));
    }
}
