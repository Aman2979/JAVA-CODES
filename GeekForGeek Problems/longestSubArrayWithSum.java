import java.util.HashMap;

public class longestSubArrayWithSum {
    private static int brute(int []arr, int k){
        int len = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int l = i; l < j; l++) {
                    sum += arr[l];
                    if (sum == k) len = Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }

    private static int bruteOptimize(int []arr, int k){
        int len = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) len = Math.max(len,j-i+1);
            }
        }
        return len;
    }

    private static int better(int []arr, int k){
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k){
                maxLen = Math.max(maxLen,i+1);
            }

            int rem = sum - k;
            if (preSumMap.containsKey(rem)){
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if(!preSumMap.containsKey(sum)){
                preSumMap.put(sum,i);
            }
        }
        return maxLen;
    }

    private static int Optimal(int []arr, int k){
        int sum = arr[0];
        int maxLen = 0;
        int right = 0, left = 0;
        int n = arr.length;
        while (right <n){
            while (left <=right && sum > k){
                sum -= arr[left];
                left++;
            }
            if (sum == k){
                maxLen = Math.max(maxLen,right-left+1);
            }
            right++;
            if (right < n) sum += arr[right];
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int []arr = {10, 5, 2, 7, 1, 10};
        int k = 15;
        int answer = Optimal(arr,k);
        System.out.println(answer);
    }
}
