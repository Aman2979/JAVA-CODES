import java.util.ArrayList;

public class medianOf2SortedArrays {

    //Brute Code 
//    public static double isMedian(int []arr1, int []arr2){
//        ArrayList<Integer> arr3 = new ArrayList<>();
//        int n1 = arr1.length;
//        int n2 = arr2.length;
//        int i = 0;
//        int j = 0;
//        while (i < n1 && j < n2){
//            if(arr1[i] < arr2[j]) arr3.add(arr1[i++]);
//            else arr3.add(arr2[j]);
//        }
//        while (i<n1) arr3.add(arr1[i++]);
//        while (j<n2) arr3.add(arr2[j++]);
//
//        int n = (n1+n2);
//        if(n%2 == 1){
//            return (double)(arr3.get(n/2));
//        }
//        return (double)((double) (arr3.get(n/2)) + (double)(arr3.get(n/2-1)))/2.0 ;
//    }
//    public static void main(String[] args) {
//        int []arr1 = {1, 3, 4, 7, 10, 12};
//        int [] arr2 = {2, 3, 6, 15};
//
//        System.out.println(isMedian(arr1,arr2));
//
//    }


    public static void main(String[] args) {

    }
}
