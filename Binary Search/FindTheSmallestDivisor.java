import java.util.*;
public class FindTheSmallestDivisor {
    public static int possible(int []arr, int div){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil((double)(arr[i]) / (double)(div));
        }
        return sum;
    }

    public static int format(int [] arr, int threshold){

        if (arr.length > threshold) return -1;

        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        int low = 1;
        int high = maxi;
        while (low <= high){
            int mid = (low + high)/2;
            if (possible(arr,mid) <= threshold) {
                high = mid - 1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 5, 9};
        int threshold = 7;
        int result = format(arr, threshold);
        System.out.println("Your answer will be: "+result);
    }
}
