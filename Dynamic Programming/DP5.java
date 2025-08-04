import java.util.*;

public class DP5 {
    public static int recursion(int[] nums, int n) {
        if (n == 0) return nums[n];
        if (n < 0) return 0;
        int pick = nums[n] + recursion(nums, n-2);
        int notPick = recursion(nums, n-1);
        return Math.max(pick, notPick);
    }

    public static int memorization(int[] nums, int []dp, int n) {
        if (n == 0) return nums[n];
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        int pick = nums[n] + memorization(nums, dp, n-2);
        int notPick = memorization(nums,dp, n-1);
        return dp[n] = Math.max(pick, notPick);
    }

    public static int tabulation(int[] nums,int []dp, int n) {
        dp[0] = nums[0];
        if (n >= 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        int take = Integer.MAX_VALUE;
        int nonTake = Integer.MAX_VALUE;
        for (int i = 2; i < n; i++) {
            take = nums[i] + dp[i-2];

            nonTake = dp[i-1];
            dp[i] = Math.max(take, nonTake);
        }
        return dp[n-1];
    }

    public static int spaceOptimization(int[] nums) {
        int size = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for (int i = 1; i < size; i++) {
            int take = nums[i];
            if (i > 1) take += prev2;
            int notTake = prev;
            int cur1 = Math.max(take, notTake);
            prev2 = prev;
            prev = cur1;
        }

        return prev;
    }
    public static void main(String[] args) {
        int []nums = {1,2,3,1};
        int []dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int n = nums.length;
        System.out.println(tabulation(nums, dp, n));
    }
}
