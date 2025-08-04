import java.util.*;
import java.util.HashMap;

public class maximumPossibleNumberByBinaryConcatenation {
    public static int maxGoodNumber(int[] nums) {
        int maxNum = 0;
        List<List<Integer>> permutations = new ArrayList<>();
        permute(nums, 0, permutations); // generate all permutations

        for (List<Integer> permutation : permutations) {
            String binaryConcat = "";
            for (int num : permutation) {
                binaryConcat += toBinaryString(num);
            }
            int decimalValue = binaryToDecimal(binaryConcat);
            maxNum = Math.max(maxNum, decimalValue);
        }
        return maxNum;
    }

    // Function to generate all permutations of the array
    public static void permute(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(nums, start + 1, result);
                swap(nums, start, i); // backtrack
            }
        }
    }

    // Function to swap elements in an array
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static String toBinaryString(int num){
        String binary = "";
        while (num >0){
            binary = (num%2 == 0 ? "0":"1") + binary;
            num /= 2;
        }
        return binary;
    }

    public static int binaryToDecimal(String binary){
        int decimalValue = 0;
        int base = 1;

        for (int i = binary.length()-1; i >= 0 ; i--) {
            if(binary.charAt(i) == '1'){
                decimalValue += base;
            }
            base *= 2;
        }
        return decimalValue;
    }

    public static void main(String[] args) {
        int []nums = {2,8,16};
        int ans = maxGoodNumber(nums);
        System.out.println(ans);
    }
}
