import java.util.ArrayList;
import java.util.List;

public class printAllSunSet {
    public static List<List<Integer>> usingBits(int []nums){
        List<List<Integer>> list = new ArrayList<>();
        int subSets = 1 << nums.length;
        for (int num = 0; num < subSets; num++){
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if ((num & (1 << i)) != 0){
                    tempList.add(nums[i]);
                }
            }
            list.add(tempList);
        }
        return list;
    }
    public static void main(String[] args) {
        int []nums = {1, 2, 3};
        List<List<Integer>> answer = usingBits(nums);
        System.out.println(answer);
    }
}
