import java.util.Arrays;

public class DP38 {
    public static int recursion(int []prices, int ind, int buy, int k, int n){
        //Base Cases
        if (ind == n) return 0;
        if (k == 0) return 0;

        if (buy == 1){
            return Math.max(-prices[ind] + recursion(prices, ind+1, 0, k, n),
                    recursion(prices, ind+1, 1, k, n));
        }
        return Math.max(prices[ind] + recursion(prices, ind+1, 1, k-1, n),
                recursion(prices, ind+1, 0, k, n));
    }

    public static int memorization(int []prices, int ind, int buy, int k, int n, int [][][]dp){
        //Base Cases
        if (ind == n) return 0;
        if (k == 0) return 0;

        if (dp[ind][buy][k] != -1) return dp[ind][buy][k];
        if (buy == 1){
            return dp[ind][buy][k] = Math.max(-prices[ind] + memorization(prices, ind+1, 0, k, n, dp),
                    memorization(prices, ind+1, 1, k, n, dp));
        }
        return dp[ind][buy][k] = Math.max(prices[ind] + memorization(prices, ind+1, 1, k-1, n, dp),
                memorization(prices, ind+1, 0, k, n, dp));
    }


    public static int tabulation(int []prices, int size, int capacity, int [][][]dp){
        // Base Case
        for (int buy = 0; buy <= 1; buy++) {
            for (int cap = 0; cap <= capacity; cap++) {
                dp[size][buy][cap] = 0;  // Base case: if index == size
            }
        }


        for (int ind = size-1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int k = 0; k <= capacity; k++) {
                    if (buy == 1){
                        dp[ind][buy][k] = Math.max(-prices[ind] + dp[ind+1][0][k],
                                dp[ind+1][1][k]);
                    }else {
                        dp[ind][buy][k] = Math.max(prices[ind] + dp[ind+1][1][k],
                                dp[ind+1][0][k]);
                    }
                }
            }
        }
        return dp[0][1][capacity];
    }

    public static int helperFunction(int []prices, int k){
        int n = prices.length;
        int buy = 1;
        int[][][] dp = new int[n+1][2][k+1]; // 2 for buy=0 or 1
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                Arrays.fill(dp[i][j], -1);
//            }
//        }
        return tabulation(prices, n, k, dp);
    }
    public static void main(String[] args) {
        int k = 2;
        int []prices = {2, 4, 1};
        System.out.println(helperFunction(prices, k));
    }
}
