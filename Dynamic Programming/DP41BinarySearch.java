import java.util.ArrayList;
import java.util.List;

public class DP41BinarySearch {
    public static int lowerBound(List<Integer> list, int target) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static int binarySearch(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int ind = lowerBound(list, nums[i]);
                list.set(ind, nums[i]); // Replace to maintain potential subsequence
            }
        }

        return list.size();
    }

    public static int helperFunction(int []nums){
        return binarySearch(nums);
    }
    public static void main(String[] args) {
        int []nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(helperFunction(nums));
    }
}
