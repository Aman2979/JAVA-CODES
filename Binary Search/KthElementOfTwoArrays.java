import javax.swing.*;
import java.util.ArrayList;

public class KthElementOfTwoArrays {
    public static long format(int k, int arr1[], int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;

        ArrayList<Integer> arr3 = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) arr3.add(arr1[i++]);
            else arr3.add(arr2[j]);
        }
        while (i < n1) arr3.add(arr1[i++]);
        while (j < n2) arr3.add(arr2[j++]);


        int n3 = arr3.size();
        int element = 0;
        for (i = 0; i < n3; i++) {
            element = arr3.get(k);
        }

        return (long)(element);
    }
        public static void main(String[] args) {
            int arr1[] = {2, 3, 6, 7, 9};
            int arr2[] = {1, 4, 8, 10};
            int k = 5;
            System.out.println(format(k,arr1,arr2));


    }
}
