import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetSums2 {
    private static void findPossibleSubSets(int index,int []nums, List<Integer> ds, List<List<Integer>> ansList){
        ansList.add(new ArrayList<>(ds));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            findPossibleSubSets(i+1,nums,ds,ansList);
            ds.remove(ds.size()-1);
        }
    }

    public static List<List<Integer>> OptimalCode(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findPossibleSubSets(0,nums,new ArrayList<>(),ansList);
        return ansList;
    }
    public static void main(String[] args) {
        int []nums = {1, 2, 2, 2, 3, 3};
        List<List<Integer>> answer = OptimalCode(nums);
        System.out.println(answer);
    }
}
