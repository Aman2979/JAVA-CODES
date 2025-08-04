import java.util.Arrays;

public class DP21 {
        public static int recursion(int[] arr, int index, int target) {
            if (index == 0) {
                if (target == 0 && arr[0] == 0) return 2; // pick or not pick
                if (target == 0 || target == arr[0]) return 1;
                return 0;
            }

            int notPick = recursion(arr, index - 1, target);
            int pick = 0;
            if (arr[index] <= target) {
                pick = recursion(arr, index - 1, target - arr[index]);
            }

            return pick + notPick;
        }

        public static int memorization(int[] arr, int index, int target, int [][]dp) {
            if (index == 0) {
                if (target == 0 && arr[0] == 0) return 2; // pick or not pick
                if (target == 0 || target == arr[0]) return 1;
                return 0;
            }

            if(dp[index][target] != -1) return dp[index][target];

            int notPick = memorization(arr, index - 1, target, dp);
            int pick = 0;
            if (arr[index] <= target) {
                pick = memorization(arr, index - 1, target - arr[index], dp);
            }

            return dp[index][target] = pick + notPick;
        }

        public static int helperFunction(int n, int diff, int[] arr) {
            int totalSum = 0;
            for (int auto : arr) {
                totalSum += auto;
            }

            if ((totalSum - diff < 0) || (totalSum - diff) % 2 != 0) return 0;

            int target = (totalSum - diff) / 2;

            int [][]dp = new int[n][target+1];
            for(int []row : dp){
                Arrays.fill(row, -1);
            }
            return memorization(arr, n - 1, target, dp);
        }

        public static void main(String[] args) {
            int[] arr = {5, 2, 6, 4};
            int target = 3;
            System.out.println(helperFunction(arr.length, target, arr)); // Expected output: 3
        }
}
