import java.util.Arrays;

public class DPR {
    public static boolean recursion(int []nums, int target, int ind) {
        // Base Case...
        if (target == 0) return true;
        if (ind == 0) return (nums[0] == target);
        boolean notTake = recursion(nums, target, ind-1);
        boolean take = false;
        if (target >= nums[ind]){
            take = recursion(nums, target-nums[ind], ind-1);
        }
        return notTake || take;
    }

    public static boolean memorization(int []nums, int target, int ind, int [][]dp) {
        // Base Case...
        if (target == 0) return true;
        if (ind == 0) return (nums[0] == target);
        if (dp[ind][target] != 0) return dp[ind][target] == 0 ? false : true;
        boolean notTake = memorization(nums, target, ind-1, dp);
        boolean take = false;
        if (target >= nums[ind]){
            take = memorization(nums, target-nums[ind], ind-1, dp);
        }
        dp[ind][target] = (take || notTake) ? 1 : 0;
        return notTake || take;
    }


    public static boolean helper(int []nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        if (totalSum % 2 != 0) return false;
        int target = totalSum /2;
        int [][]dp = new int[n][target+1];
        return recursion(nums, target, n-1);
    }
    public static void main(String[] args) {
        int []nums = {1, 5, 11, 5};
        System.out.println(helper(nums));
    }
}