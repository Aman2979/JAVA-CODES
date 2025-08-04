import java.util.*;

public class fourSum {
    public static List<List<Integer>> fourSum1(int[] nums, int target) {

//        brute force solution.
//        Set<List<Integer>> st = new HashSet<>();
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                for (int k = j+1; k < n; k++) {
//                    for (int l = k+1;l < n; l++) {
//                        long sum = (long) nums[i]+ nums[j];
//                        sum += nums[k];
//                        sum += nums[l];
//
//                        if(sum == target){
//                            List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
//                            Collections.sort(temp);
//                            st.add(temp);
//                        }
//                    }
//                }
//            }
//        }
//        List<List<Integer>> ans = new ArrayList<>(st);
//        return ans;
//    }
//    public static void main(String[] args) {
//        int []nums = {1,0,-1,0,-2,2};
//        int target = 0;
//        List<List<Integer>> ans = fourSum1(nums,target);
//        System.out.println(ans);




//      Better solution.
//        Set<List<Integer>> st = new HashSet<>();
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                Set<Long> hashSet = new HashSet<>();
//                for (int k = j+1; k < n; k++) {
//                    long sum = nums[i] + nums[j];
//                    sum += nums[k];
//                    long fourth = target - sum;
//                    if (hashSet.contains(fourth)) {
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(nums[i]);
//                        temp.add(nums[j]);
//                        temp.add(nums[k]);
//                        temp.add((int) fourth);
//                        temp.sort(Integer::compareTo);
//                        st.add(temp);
//                    }
//                    // put the kth element into the hashset:
//                    hashSet.add((long) nums[k]);
//                }
//
//            }
//        }
//        List<List<Integer>> ans = new ArrayList<>(st);
//        return ans;
//    }
//    public static void main(String[] args) {
//        int []nums = {1,0,-1,0,-2,2};
//        int target = 0;
//        List<List<Integer>> ans = fourSum1(nums,target);
//        System.out.println(ans);
//    }





//      Most Optimal Solution.
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < n; j++) {
                if(j != (i+1) && nums[j] == nums[j-1]) continue;

                int k = j+1;
                int l = n-1;
                while (k<l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if(sum == target){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        while (k<l && nums[k] == nums[k-1]) k++;
                        while (k < l && nums[l] == nums[l+1]) l--;
                    }
                    else if(sum < target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int []nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = fourSum1(nums,target);
        System.out.println(ans);
    }
}
