import java.util.ArrayList;

public class unionOfTwoArrays {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m){
        // add your code here
        ArrayList<Integer> unionAns = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i<n && j<m){
            if (arr1[i] <= arr2[j]){
                if (unionAns.size() == 0 || unionAns.get(unionAns.size()-1) != arr1[i]){
                    unionAns.add(arr1[i]);
                }
                i++;
            }else{
                if (unionAns.size() == 0 || unionAns.get(unionAns.size()-1) != arr2[j]){
                    unionAns.add(arr2[j]);
                }
                j++;
            }
        }

        while (i<n){
            if (unionAns.get(unionAns.size()-1) != arr1[i]){
                unionAns.add(arr1[i]);
            }
            i++;
        }

        while (j<m){
            if (unionAns.get(unionAns.size()-1) != arr2[j]) {
                unionAns.add(arr2[j]);
            }
            j++;
        }

        return unionAns;
    }

    public static void main(String[] args) {
         int []arr1 = {2, 3, 4, 5};
         int []arr2 = {2, 3, 6, 7};
         int n = arr1.length;
         int m = arr2.length;
        ArrayList<Integer> ans = findUnion(arr1, arr2,n,m);
        System.out.println(ans);
    }
}
