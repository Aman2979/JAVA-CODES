import java.lang.reflect.Array;
import java.util.Arrays;

public class KthMissingPositiveNumber {
    public static int format(int [] arr, int k){
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low<=high){
            int mid = (low+high)/2;
            int miss = arr[mid] - (mid+1);
            if (miss < k) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

//  kth missing number = arr[high] + k - (arr[high] - (high+1))
//   =  arr[high] + k - arr[high] + high + 1
//   = (k + high + 1)  or we use (low+k).

        return (low + k);
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4};
        int k = 2;
        int result = format(arr,k);
        System.out.println("Your missing number is: "+result);
    }
}
