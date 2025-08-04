import java.util.HashMap;
import java.util.Map;

public class kDifferentIntegers {
    public static int bruteSolution(int []nums, int k){
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(nums[j], map.getOrDefault(nums[j],0)+1);
                if (map.size() == k){
                    count++;
                }else if(map.size() > k){
                    break;
                }
            }
        }
        return count;
    }

    public static int optimalSolution(int []nums, int k){
        return helperFunction(nums, k) - helperFunction(nums,k-1);
    }

    public static int helperFunction(int []nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int count = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left])-1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            count += (right-left+1);
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        int []nums = {1,2,1,2,3};
        int k = 2;
        int answer = optimalSolution(nums, k);
        System.out.println(answer);
    }
}
