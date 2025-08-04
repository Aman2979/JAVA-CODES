import java.util.Arrays;

public class DP17 {
    public static int recursion(int []arr, int index, int K){
        if (index == 0){
            if (K == 0 && arr[0] == 0) return 2;
            if (K == 0 || K == arr[0]) return 1;
            return 0;
        }
        int notPick = recursion(arr,index-1, K);
        int pick = 0;
        if (arr[index] <= K) {
            pick = recursion(arr,index-1, K-arr[index]);
        }
        return pick+notPick;
    }

    public static int memorization(int []arr, int [][]dp, int index, int K){
        if (index == 0){
            if (K == 0 && arr[0] == 0) return 2;
            if (K == 0 || K == arr[0]) return 1;
            return 0;
        }
        if (dp[index][K] != -1) return dp[index][K];
        int notPick = memorization(arr,dp,index-1, K);
        int pick = 0;
        if (arr[index] <= K) {
            pick = memorization(arr,dp,index-1, K-arr[index]);
        }
        return dp[index][K] = pick+notPick;
    }

    public static int tabulation(int[] arr, int[][] dp, int index, int K) {
        // Base case initialization
        for (int i = 0; i < index; i++) {
            dp[i][0] = 1;
        }

        if (arr[0] == 0) {
            dp[0][0] = 2;  // pick or not pick 0
        } else {
            dp[0][0] = 1;  // only not pick
        }

        if (arr[0] != 0 && arr[0] <= K) dp[0][arr[0]] = 1;

        // Fill DP table
        for (int ind = 1; ind < index; ind++) {
            for (int j = 0; j <= K; j++) {
                int notPick = dp[ind - 1][j];
                int pick = 0;
                if (arr[ind] <= j) {
                    pick = dp[ind - 1][j - arr[ind]];
                }
                dp[ind][j] = pick + notPick;
            }
        }

        return dp[index - 1][K];
    }

    public static int spaceOptimization(int []num, int k){
        int n = num.length;

        int[] prev = new int[k + 1];
        prev[0] = 1;
        if (num[0] <= k) {
            prev[num[0]] = 1;
        }
        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[k + 1];
            cur[0] = 1;

            for (int target = 1; target <= k; target++) {
                int notTaken = prev[target];
                int taken = 0;
                if (num[ind] <= target) {
                    taken = prev[target - num[ind]];
                }
                cur[target] = notTaken + taken;
            }
            prev = cur;
        }
        return prev[k];
    }

    public static int helperFunction(int[] arr, int K) {
        int index = arr.length;
        int[][] dp = new int[index][K + 1];  // initialize with 0s by default
        return memorization(arr, dp,arr.length-1,K);
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2};
        int K = 4;
        System.out.println("The Output is : " + helperFunction(arr, K));
    }
}
