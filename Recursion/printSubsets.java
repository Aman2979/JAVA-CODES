import java.util.ArrayList;
import java.util.List;

public class printSubsets {
    public static List<List<Integer>> subsets1(int index, int []nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (index == n) {
            ans.add(new ArrayList<>());  // Add empty subset
            return ans;
        }

        List<List<Integer>> temp = subsets1(index + 1, nums);  // Recursive call
        ans.addAll(temp);  // Add all subsets from the recursive call

        for (List<Integer> subset : temp) {
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(nums[index]);  // Add current element to each subset
            ans.add(newSubset);
        }

        return ans;
    }

    public static List<List<Integer>> subsets(int []nums) {
        return subsets1(0, nums);
    }
    public static void main(String[] args) {
        int []nums = {3, 2, 1};

        List<List<Integer>> ans = subsets(nums);
        System.out.println(ans);
    }
}
