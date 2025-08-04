import java.util.Arrays;

public class DP4 {
    public static int recursion(int []arr, int k, int n){
        if (n == 0) return 0;
        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n-i >= 0) {
                int jump = recursion(arr, k, n-i) + Math.abs(arr[n] - arr[n - i]);
                minJumps = Math.min(minJumps, jump);
            }
        }
        return minJumps;
    }

    public static int recursionToDp(int []arr, int []dp, int k, int n){
        // TC = O(n)*O(K).
        // SC = O(n)+O(n).
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n-i >= 0) {
                int jump = recursionToDp(arr,dp, k, n-i) + Math.abs(arr[n] - arr[n - i]);
                minJumps = Math.min(minJumps, jump);
            }
        }
        return dp[n] = minJumps;
    }

    public static int tabulation(int []arr,int []dp, int k, int n){
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minJumps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i-j >= 0) {
                    int jump = dp[i-j] + Math.abs(arr[i] - arr[i - j]);
                    minJumps = Math.min(minJumps, jump);
                }
            }
            dp[i] = minJumps;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int []arr = {10, 5, 20, 0, 15};
        int k = 2;
        int n = arr.length-1;
        int []dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(tabulation(arr,dp,k, n));
    }
}
