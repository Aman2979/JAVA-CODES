import java.util.Arrays;

public class DP39 {
    public static int recursion(int []prices, int ind, int buy, int n){
        if (ind >= n) return 0;

        int maxProfits = 0;
        if (buy == 1){
            maxProfits = Math.max(-prices[ind]+recursion(prices, ind+1, 0, n),
                    recursion(prices, ind+1, 1, n));
        }else {
            maxProfits = Math.max(prices[ind]+recursion(prices, ind+2, 1, n),
                    recursion(prices, ind+1, 0, n));
        }
        return maxProfits;
    }

    public static int memorization(int []prices, int ind, int buy, int n, int [][]dp){
        if (ind == n) return 0;

        if (dp[ind][buy] != -1) return dp[ind][buy];
        int maxProfits = 0;
        if (buy == 1){
            maxProfits = Math.max(-prices[ind]+memorization(prices, ind+1, 0, n, dp),
                    memorization(prices, ind+1, 1, n, dp));
        }else {
            maxProfits = Math.max(prices[ind]+memorization(prices, ind+1, 1, n, dp),
                    memorization(prices, ind+1, 0, n, dp));
        }
        return dp[ind][buy] = maxProfits;
    }

    public static int tabulation(int []prices, int n, int [][]dp){
        dp[n][0] = dp[n][1] = 0;

        for (int ind = n-1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int maxProfits = 0;
                if (buy == 1){
                    maxProfits = Math.max(-prices[ind]+dp[ind+1][0],
                            dp[ind+1][1]);
                }else {
                    maxProfits = Math.max(prices[ind]+dp[ind+2][1],
                            dp[ind+1][0]);
                }
                dp[ind][buy] = maxProfits;
            }
        }
        return dp[0][1];
    }

    public static int helperFunction(int []prices){
        int n = prices.length;
        int buy = 1;
        int [][]dp = new int[n+2][2];
//        for (int []row: dp){
//            Arrays.fill(row, -1);
//        }
        return tabulation(prices, n, dp);
    }
    public static void main(String[] args) {
        int [] prices = {2, 4, 1, 0, 0, 10};
        System.out.println(helperFunction(prices));
    }
}
