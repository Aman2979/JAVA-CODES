import java.util.Arrays;

public class Main {
    public static int recursion(int []arr, int n, int flag, int ind, int fee, int [][]dp){
        if (ind >= n) return 0;

        if (dp[ind][flag] != -1) return dp[ind][flag];
        if (flag == 1){
            return dp[ind][flag] = Math.max(-arr[ind] + recursion(arr, n,0, ind+1,fee, dp),
                    recursion(arr, n,1, ind+1, fee, dp));
        }
        return dp[ind][flag] = Math.max(arr[ind-fee] + recursion(arr, n, 1, ind+2, fee, dp),
                    recursion(arr, n, 0, ind+1, fee, dp));
    }

    public static int helper(int []arr){
        int n = arr.length;
        int flag = 1;
        int fee = 2;
        int [][]dp = new int[n+1][2];
        for (int []row : dp) {
            Arrays.fill(row, -1);
        }
        return recursion(arr, n, flag, 0, fee, dp);
    }
    public static void main(String[] args) {
        int []arr = {1, 3, 2, 8, 4, 9};
        System.out.println(helper(arr));
    }
}
