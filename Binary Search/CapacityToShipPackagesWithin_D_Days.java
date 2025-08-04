import java.util.*;
public class CapacityToShipPackagesWithin_D_Days {
    public static int findDays(int[] arr, int cap) {
        int days = 1; //First day...
        int load = 0;
        int n = arr.length; //size of array...
        for (int i = 0; i < n; i++) {
            if (load + arr[i] > cap) {
                days += 1; //move to next day...
                load = arr[i]; //load the weight...
            } else {
                //load the weight on the same day...
                load += arr[i];
            }
        }
        return days;
    }

    public static int format(int [] arr, int days){
        //Find Maximum Element...
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
            sum += arr[i];
        }

        int low = maxi;
        int high = sum;
        while (low <= high){
            int mid = (low+high)/2;
            int numberOfDays = findDays(arr, mid);
            if (numberOfDays <= days){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int answer = format(arr, days);
        System.out.println("The Capacity is: "+answer);
    }
}
