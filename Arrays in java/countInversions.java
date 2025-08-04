import java.util.*;
public class countInversions {
    private static int merge(long[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        int cnt = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add((int) arr[left]);
                left++;
            } else {
                temp.add((int) arr[right]);
                cnt += (mid - left + 1);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add((int) arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add((int) arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt;
    }

    public static int mergeSort(long[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }

    static long inversionCount(long arr[]) {

      /* Bruteforce Approach

        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] > arr[j]){
                    count += 1;
                }
            }
        }
        return count;*/


        //Optimal approach
        int n = arr.length;
        return mergeSort(arr,0,n-1);
    }
    public static void main(String[] args) {
        long []arr = {2, 3, 4, 5, 6};
        System.out.println(inversionCount(arr));
    }
}
