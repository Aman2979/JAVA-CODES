
public class Dp2 {
    public static int recursion(int n){
        if (n == 1) return 1;
        if (n == 0) return 1;

        int left = recursion(n-1);
        int right = recursion(n-2);
        return left+right;
    }

    public static int memorization(int n, int []dp){
        if (n == 1) return 1;
        if (n == 0) return 1;
        if (dp[n] != -1) return dp[n]; // ---> create size n+1, then get answer
        int left = recursion(n-1);
        int right = recursion(n-2);
        return dp[n] = left+right;
    }

    public static int tabulation(int n, int []dp){
        dp[0] = 1;
        dp[1] = 1;
        int left = dp[n-1];
        int right = dp[n-2];
        return dp[n] = left+right;
    }

    public static int spaceOptimization(int n){
        if (n <= 3) return n;
        int prev1 = 3, prev2 = 2; // dp[1] and dp[0]
        for (int i = 4; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(spaceOptimization(n));
    }
}
