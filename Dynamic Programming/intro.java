import java.util.Arrays;

public class intro {
    public static int fun(int n, int []dp){
        // Memorization Methode.
        // TC = O(n, Linear recursion Calls).
        // SC = (n, for recursion stack space) + O(n, for Array space).
        if (n <= 1){
            return n;
        }
        if (dp[n] != -1) return dp[n];
        return dp[n] = fun(n-1, dp) + fun(n-2, dp);
    }

    public static void fun2(int n, int []dp){
        // Tabulation Methode
        // TC = O(n, Linear).
        // SC = O(n, for Array space)

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
    }
    public static void fun3(int n){
        // Space Optimization.
        // TC = O(n, Single Pass).
        // SC = O(1)
        int prev2 = 0;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        System.out.println(prev);
    }
    
    public static void main(String[] args) {
        int n = 7;
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);
        fun3(n);

    }
}
