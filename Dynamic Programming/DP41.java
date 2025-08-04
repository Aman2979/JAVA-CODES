import java.util.Arrays;

public class DP41 {
    public static int recursion(int[] nums, int ind, int prev, int size) {
        if (ind == size) return 0;

        // Not Take
        int len = recursion(nums, ind + 1, prev, size);
        if (prev == -1 || nums[ind] > nums[prev]) {
            len = Math.max(len, 1 + recursion(nums, ind + 1, ind, size));
        }
        return len;
    }

    public static int memorization(int[] nums, int ind, int prev, int size, int [][]dp) {
        if (ind == size) return 0;

        if (dp[ind][prev+1] != -1) return dp[ind][prev+1];
        // Not Take
        int len = memorization(nums, ind + 1, prev, size, dp);
        if (prev == -1 || nums[ind] > nums[prev]) {
            len = Math.max(len, 1 + memorization(nums, ind + 1, ind, size, dp));
        }
        return dp[ind][prev+1] =  len;
    }

    public static int tabulation(int[] nums, int size, int [][]dp) {
        for (int ind = size-1; ind >= 0; ind--) {
            for (int prev = ind-1; prev >= -1; prev--) {
                int len = dp[ind + 1][prev+1];
                if (prev == -1 || nums[ind] > nums[prev]) {
                    len = Math.max(len, 1 + dp[ind + 1][ind+1]);
                }
                dp[ind][prev+1] =  len;
            }
        }
        return dp[0][-1+1];
    }

    public static int anotherTabulation(int[] nums, int size, int []dp1) {
        int maxi = 1;
        for (int index = 0; index < size; index++) {
            dp1[index] = 1; // Initialization fix
            for (int prev = 0; prev < index; prev++) {
                if (nums[index] > nums[prev]){
                    dp1[index] = Math.max(dp1[index], 1 + dp1[prev]);
                }
            }
            maxi = Math.max(maxi, dp1[index]);
        }
        return maxi;
    }

    public static int spaceOptimization(int[] nums, int size) {
        int []curr = new int[size+1];
        int []next = new int[size+1];
        for (int ind = size-1; ind >= 0; ind--) {
            for (int prev = ind-1; prev >= -1; prev--) {
                int len = next[prev+1];
                if (prev == -1 || nums[ind] > nums[prev]) {
                    len = Math.max(len, 1 + next[ind+1]);
                }
                curr[prev+1] =  len;
            }
            next = curr;
        }
        return next[-1+1];
    }


    public static int helperFunction(int[] nums) {
        int size = nums.length;
        int prev = -1;
        int [][]dp = new int[size+1][size+1];
        for(int []row : dp){
            Arrays.fill(row, 0);
        }

        int []dp1 = new int[size]; // for anotherTabulation method
        return anotherTabulation(nums, size, dp1);
    }
    public static void main(String[] args) {
        int []nums = {10,9,2,5,3,7,101,18};
        System.out.println(helperFunction(nums));
    }
}
