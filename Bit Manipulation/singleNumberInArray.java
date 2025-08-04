import java.util.HashMap;

public class singleNumberInArray {
    public static int bruteSolution(int []nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for (var entry : map.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int optimalSolution(int []nums){
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        int []nums = {2, 2, 1, 1, 4, 7, 4};
        int ans = optimalSolution(nums);
        System.out.println(ans);
    }
}
