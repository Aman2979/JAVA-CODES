import java.util.Arrays;
import java.util.HashMap;
public class singleNumberIII {
    public static int[] bruteSolution(int []nums){
        // Step 1: Create a HashMap to store frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2]; // Array to store the two unique numbers
        int n = nums.length;

        // Step 2: Count occurrences of each number
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Step 3: Identify numbers that appear exactly once
        int index = 0;
        for (var entry : map.entrySet()) {
            if (entry.getValue() == 1) { // If the number appears only once
                ans[index++] = entry.getKey(); // Store it in the answer array
            }
        }

        // Step 4: Return the array containing the two unique numbers
        return ans;
    }

    public static int[] optimalSolution(int []nums){
        int[] ans = new int[2];
        int xor = 0;

        // Step 1: XOR all numbers to get xor of two unique numbers
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find rightmost set bit in xor
        int rightMost = xor & -xor;

        // Step 3: Partition numbers into two groups
        int b1 = 0, b2 = 0;
        for (int num : nums) {
            if ((num & rightMost) != 0) {
                b1 ^= num;
            } else {
                b2 ^= num;
            }
        }

        ans[0] = b1;
        ans[1] = b2;
        return ans;
    }
    public static void main(String[] args) {
        int []nums = {1,2,1,4,2,5};
        int []ans = optimalSolution(nums);
        System.out.println(Arrays.toString(ans));
    }
}
