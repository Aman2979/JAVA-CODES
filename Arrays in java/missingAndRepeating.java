public class missingAndRepeating {
    public static int[] findTwoElement(int arr[]) {
        long n = arr.length;
        long sN = (n*(n+1))/2;
        long s2N = (n*(n+1)*(2*n+1))/6;
        long s = 0, s2 = 0;
        for (int i = 0; i < n; i++){
            s += arr[i];
            s2 += (long)arr[i] * (long)arr[i];
        }

        long val1 = s - sN;
        long val2 = s2 - s2N;
        val2 = val2/val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[]{(int)x, (int)y};
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,2,1,1};
        int []ans = findTwoElement(arr);
        System.out.println("Missing is : "+ ans[0]+" And repeating is: " +ans[1]);

    }
}
//TC = O(n)
//SC = O(1)
