import java.util.Arrays;

public class DP15 {
    public static boolean recursion(int []nums, int index, int target){
        if (target == 0) return true;
        if (index == 0) return (nums[0] == target);
        boolean notPick = recursion(nums, index-1, target);
        boolean take = false;
        if (target >= nums[index]){
            take = recursion(nums, index-1, target-nums[index]);
        }
        return (notPick || take);
    }

    public static boolean memorization(int []nums, int [][]dp, int index, int target){
        if (target == 0) return true;
        if (index == 0) return (nums[0] == target);
        if (dp[index][target] != -1) return dp[index][target] == 0 ? false : true;
        boolean notPick = memorization(nums,dp, index-1, target);
        boolean take = false;
        if (target >= nums[index]){
            take = memorization(nums, dp,index-1, target-nums[index]);
        }
        dp[index][target] = notPick || take ? 1 : 0;
        return notPick || take;
    }

    public static boolean tabulation(int []arr, boolean [][]dp, int index, int target){
        for (int i = 0; i < index; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;  // base case: single element can form subset
        }
        for (int ind = 1; ind < index; ind++) {
            for (int k = 1; k <= target; k++) {
                boolean notPick = dp[ind-1][k];
                boolean pick = false;
                if (k >= arr[ind]){
                    pick = dp[ind-1][k-arr[ind]];
                }
                dp[ind][k] = notPick || pick;
            }
        }
        return dp[index-1][target];
    }

    public static boolean oneMoreHelperFun(int []nums){
        int size = nums.length;
        int totalSum = 0;
        for (int i = 0; i < size; i++) {
            totalSum += nums[i];
        }
        if (totalSum % 2 != 0) return false;
        int target = totalSum/2;

        boolean [][]dp = new boolean[size][target+1];
        return tabulation(nums, dp, size-1,target);
    }

    public static void main(String[] args) {
        int []nums = {1, 5, 11, 5};
        System.out.println(oneMoreHelperFun(nums));
    }
}
