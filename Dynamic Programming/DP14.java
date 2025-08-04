import java.util.Arrays;

public class DP14 {
    public static boolean recursion(int []arr, int index, int target){
        if (target == 0) return true;
        if (index == 0) return (arr[0] == target);
        boolean notPick = recursion(arr, index-1, target);
        boolean take = false;
        if (target >= arr[index]){
            take = recursion(arr, index-1, target-arr[index]);
        }
        return (notPick || take);
    }

    public static boolean memorization(int []arr, int [][]dp, int index, int target){
        if (target == 0) return true;
        if (index == 0) return (arr[0] == target);
        if (dp[index][target] != -1) return dp[index][target] == 0 ? false : true;
        boolean notPick = memorization(arr, dp,index-1, target);
        boolean pick = false;
        if (target >= arr[index]){
            pick = memorization(arr, dp, index-1, target-arr[index]);
        }
        dp[index][target] = notPick || pick ? 1 : 0;
        return notPick || pick;
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

    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4};
        int target = 4;

//        int [][]dp = new int[arr.length][target+1]; // This is for memorization
//        for (int []row : dp){
//            Arrays.fill(row, -1);
//        }

        boolean [][]dp = new boolean[arr.length][target+1]; // This is for tabulation
        System.out.println(tabulation(arr, dp,arr.length, target));
    }
}
