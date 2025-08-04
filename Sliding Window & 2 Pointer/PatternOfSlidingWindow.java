public class PatternOfSlidingWindow {
    public static int bruteSolution(int []arr, int k){
        //Tc = O(n2)
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum <= k) {
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }
    public static int BetterSolution(int []arr, int k){
        //Tc = O(n)
        int n = arr.length;
        int l = 0, r = 0;
        int sum = 0;
        int maxLen = 0;
        while (r < n){
            sum += arr[r];
            if (sum > k){
                sum -= arr[l];
                l++;
            }
            if(sum <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }
        }
        return maxLen;
    }

    public static int optimalSolution(int []arr, int k){
        //Tc = O(2n)
        int n = arr.length;
        int l = 0, r = 0;
        int sum = 0;
        int maxLen = 0;
        while (r < n){
            sum += arr[r];
            while (sum > k) {
                sum -= arr[l];
                l++;
            }
            if (sum <= k) {
                maxLen = Math.max(maxLen, r-l+1);
                r++;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int []arr = {2, 5, 1, 7, 10};
        int k = 14;
        int answer = optimalSolution(arr, k);
        System.out.println(answer);
    }
}
