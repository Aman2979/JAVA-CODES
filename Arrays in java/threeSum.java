import java.util.*;
public class threeSum {
    public static List<List<Integer>> threeSum1(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> st = new HashSet<>();
        int []arr1 = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
        List<List<Integer>>  ans = new ArrayList<>(st);
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(i>0 && arr[i] == arr[i-1]) continue;
            int j = i+1;
            int k = n - 1;
            while (j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum < 0){
                    j++;
                }else if(sum>0) {
                    k--;
                }else{
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while (j<k && arr[j] == arr[j-1]) j++;
                    while (j<k && arr[k] == arr[k+1]) k--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum2(arr);
        System.out.println(result);
    }
}
