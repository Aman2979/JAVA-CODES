import java.util.ArrayList;
import java.util.List;
public class sameNumber {
    public static int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] frequency = new int[n];

        // Count the frequency of each number
        for (int num : nums) {
            frequency[num]++;
        }

        // Find the two numbers with frequency 2
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (frequency[i] == 2) {
                ans.add(i);
            }
        }

        // Return the result as an array
        return new int[]{ans.get(0), ans.get(1)};
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 0}; // Example input
        int[] result = getSneakyNumbers(nums);

        // Output the result
        System.out.println("The sneaky numbers are: " + result[0] + " and " + result[1]);
    }
}
