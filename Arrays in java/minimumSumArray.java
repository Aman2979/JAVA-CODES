public class minimumSumArray {
    public static int maxSubarraySum(int[] arr) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum += arr[i];
                max = Math.max(sum,max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int []arr = {2, 3, -8, 7, -1, 2, 3};
        int ans = maxSubarraySum(arr);
        System.out.println(ans);
    }
}
