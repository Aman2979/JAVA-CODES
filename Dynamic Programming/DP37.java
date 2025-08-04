import java.util.Arrays;

public class DP37 {
    public static int recursion(int []prices, int ind, int n, int buy, int cap){
        if (ind == n) return 0;
        if (cap == 0) return 0;

        // Buy Case
        if (buy == 1){
            return Math.max(-prices[ind] + recursion(prices, ind+1,n, 0, cap),
                    recursion(prices, ind+1, n,1, cap));
        }else { // Sell Case
            return Math.max(prices[ind] + recursion(prices, ind+1, n,1, cap-1),
                    recursion(prices, ind+1, n,0, cap));
        }
    }

    public static int memorization(int []prices, int ind, int n, int buy, int cap, int [][][]dp){
        if (ind == n) return 0;
        if (cap == 0) return 0;

        if (dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        // Buy Case
        if (buy == 1){
            return dp[ind][buy][cap] = Math.max(-prices[ind] + memorization(prices, ind+1,n, 0, cap, dp),
                    memorization(prices, ind+1, n,1, cap, dp));
        }else { // Sell Case
            return dp[ind][buy][cap] = Math.max(prices[ind] + memorization(prices, ind+1, n,1, cap-1, dp),
                    memorization(prices, ind+1, n,0, cap, dp));
        }
    }

    public static int tabulation(int []prices,int size, int [][][]dp){
        // Base Case of Code
        for (int buy = 0; buy <= 1; buy++) {
            for (int cap = 0; cap <= 2; cap++) {
                dp[size][buy][cap] = 0;  // Base case: if index == size
            }
        }


        for (int ind = size-1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1){
                        dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind+1][0][cap],
                                dp[ind+1][1][cap]);
                    }else { // Sell Case
                        dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind+1][1][cap-1],
                                dp[ind+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
    public static int helperFunction(int []prices){
        int n = prices.length;
        int cap = 2;
        int buy = 1;
        int [][][]dp = new int[n+1][2][3];
        // Properly fill the 3D array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], 0);
            }
        }
        return tabulation(prices, n, dp);
    }
    public static void main(String[] args) {
        int []prices = {3,3,5,0,0,3,1,4};
        System.out.println(helperFunction(prices));
    }
}
