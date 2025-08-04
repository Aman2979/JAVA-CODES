import java.util.Arrays;
public class DP20 {
    public static int recursion(int []coins, int amount, int ind){
        // Base Case
        if (ind == 0){
            if (amount % coins[ind] == 0) return amount/coins[ind];
            else return (int) Math.pow(10, 9);
        }

        int notTake = recursion(coins, amount, ind-1);
        int take = (int) Math.pow(10, 9);
        if (coins[ind] <= amount){
            take = 1 + recursion(coins, amount-coins[ind], ind);
        }
        return Math.min(notTake, take);
    }

    public static int memorization(int []coins, int amount, int ind, int[][] dp){
        // Base Case
        if (ind == 0){
            if (amount % coins[ind] == 0) return amount/coins[ind];
            else return (int) Math.pow(10, 9);
        }

        if(dp[ind][amount] != -1) return dp[ind][amount];
        int notTake = memorization(coins, amount, ind-1, dp);
        int take = (int) Math.pow(10, 9);
        if (coins[ind] <= amount){
            take = 1 + memorization(coins, amount-coins[ind], ind, dp);
        }
        return dp[ind][amount] = Math.min(notTake, take);
    }

    public static int tabulation(int []coins, int amount, int ind, int[][] dp){
        // Base Case
        return -1;
    }

    public static int helperFunction(int []coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return recursion(coins, amount, n-1);
    }
    public static void main(String[] args) {
        int []coins = {1, 2, 5};
        int amount = 11;
        int ans = helperFunction(coins, amount);
        if (ans == Math.pow(10, 9)){
            System.out.println(-1);
        }else {
            System.out.println(ans);
        }
    }
}
