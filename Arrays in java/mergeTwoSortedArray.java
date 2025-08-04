import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeTwoSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        List<Integer> res = new ArrayList<>();
//        int i = 0;
//        int j = 0;
//        while (i < m && j < n){
//                if(nums1[i] <= nums2[j]){
//                        res.add(nums1[i]);
//                        i++;
//                }else{
//                        res.add(nums2[j]);
//                        j++;
//                }
//            }
//
//        while (i < m){
//            res.add(nums1[i]);
//            i++;
//        }
//
//        while (j < n){
//                res.add(nums1[j]);
//                j++;
//        }
//
//        for (int k = 0; k < res.size(); k++) {
//            if(i<n) nums1[i] = res.get(i);
//            else nums2[i-n] = res.get(i);
//        }
//
//        for (int k = 0; k < res.size(); k++) {
//            System.out.print(res.get(k)+" ");
//        }


        //Second Approach
        int left = m-1;
        int right = 0;

        while (left >= 0 && right < n){
            if(nums1[left] > nums2[right]){
                //Swap
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            }else {
                break;
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
        }
    }
    public static void main(String[] args) {
        int []nums1 = {1,2,3, 10 };
        int m = nums1.length;
        int []nums2 = {2,5,6};
        int n = nums2.length;
        merge(nums1,m,nums2,n);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(nums2[i] + " ");
        }
    }
}
