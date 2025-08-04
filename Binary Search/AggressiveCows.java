import java.util.*;

public class AggressiveCows {
    public static boolean isPossible(int []arr, int dis, int cow){
        int cuntCows =  1, last = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - last >= dis){
                cuntCows++;
                last = arr[i];
            }
            if(cuntCows >= cow){
                return true;
            }
        }
        return false;
    }

    public static int isFormat(int []arr, int k){
        Arrays.sort(arr);
        int n = arr.length;
        int low = 1, high = arr[n-1] - arr[0];
        while (low<= high){
            int mid = (low+high)/2;
            if(isPossible(arr, mid, k) == true){
                low = mid+1;
            }else{
                high = mid-1;
            }

        }
        return high;
    }

    public static void main(String[] args) {
        int [] arr = {0, 3, 4, 7, 9, 10};
        int k = 4;
        int n = arr.length;
        int res = isFormat(arr,k);
        System.out.println("The result is: "+res);
    }
}
