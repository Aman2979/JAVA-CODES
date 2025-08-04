import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination2 {
    private static void findCombinations(int ind,int []candidates, int target,List<List<Integer>> ans, List<Integer> ds){
         if (target == 0) {
             ans.add(new ArrayList<>(ds));
             return;
         }
        for (int i = ind; i < candidates.length; i++) {
            if (i>ind && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] > target) break;

            ds.add(candidates[i]);
            findCombinations(i+1, candidates,target-candidates[i], ans,ds);
            ds.remove(ds.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        int []candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = combinationSum2(candidates,target);
        System.out.println(ans);
    }
}
