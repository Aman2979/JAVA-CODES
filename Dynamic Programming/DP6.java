import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP6 {
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
        int []nums = {2,3,2};
        int []temp1 = new int[nums.length];
        int []temp2 = new int[nums.length];
//        if (nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) temp1[i] = nums[i];
            if (i != nums.length-1) temp2[i] = nums[i];
        }
        int maxi = Math.max(spaceOptimization(temp1), spaceOptimization(temp2));
        System.out.println(maxi);
    }
}
