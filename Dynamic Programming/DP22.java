import java.util.Arrays;

public class DP22 {
    public static int recursion(int []coins, int amount, int index){
        // base case
        if (index == 0){
            if (amount % coins[index] == 0) return 1;
            else return 0;
        }

        int notTake = recursion(coins, amount, index-1);
        int take = 0;
        if (coins[index] <= amount){
            take = recursion(coins, amount-coins[index], index);
        }
        return (notTake + take);
    }


    public static int memorization(int []coins, int amount, int index, int [][]dp){
        // base case
        if (index == 0){
            if (amount % coins[index] == 0) return 1;
            else return 0;
        }

        if (dp[index][amount] != -1) return dp[index][amount];
        int notTake = memorization(coins, amount, index-1, dp);
        int take = 0;
        if (coins[index] <= amount){
            take = memorization(coins, amount-coins[index], index, dp);
        }
        return dp[index][amount] = (notTake + take);
    }

    public static int tabulation(int []coins, int target, int ind, int [][]dp){
        for (int i = 0; i <= target; i++) {
            if(i % coins[0] == 0) {
                dp[0][i] = 1;
            }else {
                dp[0][i] = 0;
            }
        }

        for (int index = 1; index <= ind; index++) {
            for (int amount = 0; amount <= target; amount++) {
                int notTake = dp[index-1][amount];
                int take = 0;
                if (coins[index] <= amount){
                    take = dp[index][amount-coins[index]];
                }
                dp[index][amount] = (notTake + take);
            }
        }
        return dp[ind][target];
    }

    public static int helperFunction(int []coins, int amount){
        int n = coins.length;
        int [][]dp = new int[n][amount+1];
        for (int []row : dp){
            Arrays.fill(row, 0);
        }
        return tabulation(coins, amount, n-1, dp);
    }
    public static void main(String[] args) {
        int []coins = {1, 2, 5};
        int amount = 5;
        System.out.println(helperFunction(coins, amount));
    }
}
