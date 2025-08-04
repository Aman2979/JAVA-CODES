import java.util.ArrayList;
import java.util.Arrays;

public class interSectionWithDuplicates {
//    public static ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        int n = a.length;
//        int m = b.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (!ans.contains(a[i]) && a[i] == b[j]){
//                    ans.add(a[i]);
//                }
//            }
//        }
//        return ans;
//    }

    public static ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        int m = b.length;
        int i = 0, j= 0;
        while (i<n && j< m){
            if (!ans.contains(a[i]) && a[i] == b[j]){
                ans.add(a[i]);
                i++;
                j++;
            } else if (a[i] == b[i]) {
                i++;
                j++;
            }else if(a[i] < b[i]) {
                i++;
            }else {
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int []a = {1, 2, 1, 3, 1};
        int []b = {3, 1, 3, 4, 1};
        ArrayList<Integer> answer = intersectionWithDuplicates(a, b);
        System.out.println(answer);
    }
}
