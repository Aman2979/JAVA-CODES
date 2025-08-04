import java.util.Arrays;

public class DP3 {
    public static int recursion(int[] arr, int n) {
        // I try out possible ways
        // TC = O(n^2).
        // SC = O(n^2).
        if (n == 0) return 0; // Base case: at first step, no cost
        int left = recursion(arr,n - 1) + Math.abs(arr[n] - arr[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = recursion(arr,n - 2) + Math.abs(arr[n] - arr[n - 2]);
        }
        return Math.min(left, right);
    }

    public static int recursionToDP(int []arr, int []dp, int n){
        // TC = O(n).
        // SC = O(n) + O(n).
        if (n == 0) return 0; // Base case: at first step, no cost
        if (dp[n] != -1) return dp[n];
        int left = recursionToDP(arr, dp, n - 1) + Math.abs(arr[n] - arr[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = recursionToDP(arr, dp, n - 2) + Math.abs(arr[n] - arr[n - 2]);
        }
        return dp[n] = Math.min(left, right);
    }

    public static int tabulation(int []arr, int []dp, int dpSize){
        // TC = O(n).
        // SC = O(n).
        dp[0]=0;
        for(int ind=1;ind< arr.length;ind++){
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne= dp[ind-1] + Math.abs(arr[ind]-arr[ind-1]);
            if(ind>1) {
                jumpTwo = dp[ind - 2] + Math.abs(arr[ind] - arr[ind - 2]);
            }
            dp[ind]=Math.min(jumpOne, jumpTwo);
        }
        return dp[dpSize-1];
    }

    public static int spaceOptimization(int []arr){
        // TC = O(n).
        // SC = O(1).
        int prev = 0;
        int prev2 = 0;
        for(int ind = 1; ind< arr.length; ind++){
            prev2 = prev + Math.abs(arr[ind]-arr[ind-1]);
            if(ind>1) {
                prev = prev2 + Math.abs(arr[ind] - arr[ind - 2]);
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        int []arr = {3, 10, 3, 11, 3};
        int n = arr.length;
        int []dp = new int[n];
        Arrays.fill(dp, -1);
        int dpSize = dp.length;
        System.out.println(spaceOptimization(arr));
    }
}
