//    Given an array of integers arr[] and a number k, count the number
//    of subArrays having XOR of their elements as k.
public class January_3 {
public static long subarrayXor(int arr[], int k) {
    // code here
    int n = arr.length;
    long cnt = 0;
    for (int i = 0; i < n; i++) {
        long xor = 0;
        for (int j = i; j < n; j++) {
                xor = xor ^ arr[j];
                if ( k == xor) cnt++;

        }
    }
    return cnt;
}
    public static void main(String[] args) {
        int []arr = {4, 2, 2, 6, 4};
        int k = 6;
        long answer = subarrayXor(arr, k);
        System.out.println(answer);
    }
}
