import java.util.*;
public class ex{
    public static int isFormat(int []arr, int index, int ans){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(arr[low] <= arr[high]){
                if(arr[low] < arr[mid]){
                    index = mid;
                    low = arr[mid];
                }
                break;
            }

            //left half is sorted
            if(arr[low] <= arr[mid]){
                if(arr[low] < ans){
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            }else{
                if (arr[mid] < ans){
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args){
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            index = Math.min(arr[i], index);
        }
        int ans = -1;
        int result = isFormat(arr, index, ans);
        System.out.println("Your ans is: " + result);
    }
}
