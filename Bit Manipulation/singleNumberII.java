import java.util.Arrays;
import java.util.HashMap;

public class singleNumberII {
    public static int bruteSolution(int []nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (var x : map.entrySet()){
            if (x.getValue() == 1){
                return x.getKey();
            }
        }
        return -1;
    }

    public static int betterSolution(int []nums){
        int ans = 0;
        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (1 << bitIndex)) != 0){
                    cnt++;
                }
            }
            if (cnt % 3 == 1){
                ans = ans | (1 << bitIndex);
            }
        }
        return ans;
    }

    public static int betterSolution2(int []nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i+=3) {
            if (nums[i] != nums[i-1]){
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }

    public static int optimalSolution(int []nums){
        int ones = 0;
        int two = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~ two;
            two = (two ^ nums[i]) & ~ones;
        }
        return ones;
    }
    public static void main(String[] args) {
        int []nums = {3, 3, 3, 2, 1, 1, 1};
        int ans = optimalSolution(nums);
        System.out.println(ans);
    }
}
