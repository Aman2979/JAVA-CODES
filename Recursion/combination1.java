import java.util.ArrayList;
import java.util.List;

public class combination1 {
    private static void findCombinations(int ind,int []candidates, int target,List<List<Integer>> ans, List<Integer> ds){
        if (ind == candidates.length){
            if (target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (candidates[ind] <= target){
            ds.add(candidates[ind]);
            findCombinations(ind, candidates,target-candidates[ind], ans,ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(ind+1,candidates,target,ans,ds);
    }
    public static List<List<Integer>> mainFunction(int []candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        int []candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> answer = mainFunction(candidates,target);
        System.out.println(answer);
    }
}
