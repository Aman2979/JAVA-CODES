public class DP16 {
    public static int minimumSumAfterPartition(int []nums, int n){
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        Boolean [][]dp = new Boolean[n][totalSum+1];
        for (int i = 0; i <= totalSum; i++) {
            dp[0][i] = (i == nums[0]);
        }

        // Fill in the DP table using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= totalSum; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (nums[ind] <= target) {
                    taken = dp[ind - 1][target - nums[ind]];
                }

                // Update the DP table for the current element and target sum
                dp[ind][target] = notTaken || taken;
            }
        }
        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = 0; i <= totalSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totalSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }

    public static void main(String[] args) {
        int []nums = {-36, 36};
        System.out.println("Aman, Your ans is "+ minimumSumAfterPartition(nums, nums.length));
    }
}
