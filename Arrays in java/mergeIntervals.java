import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergeIntervals {
    public static List<List<Integer>> merge(int[][] intervals) {
       /* BruteForce Solution

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }
            for (int j = 0; j < n; j++){
                if(intervals[j][0] <= end){
                    end = Math.max(end,intervals[j][1]);
                }
                else {
                    break;
                }
            }
            ans.add(Arrays.asList(start,end));
        }
        return ans;*/


        //This most optimal Solution
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int n = intervals.length;
            for (int i = 0; i < n; i++) {
                // if the current interval does not
                // lie in the last interval:
                if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)) {
                    ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
                }
                // if the current interval
                // lies in the last interval:
                else {
                    ans.get(ans.size() - 1).set(1,
                            Math.max(ans.get(ans.size() - 1).get(1), intervals[i][1]));
                }
            }
        return ans;
    }

    public static void main(String[] args) {
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        List<List<Integer>> ans = merge(intervals);
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
    }
}
