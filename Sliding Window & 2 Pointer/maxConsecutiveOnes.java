public class maxConsecutiveOnes {
    public static int bruteSolution(int []arr, int k){
        //tc O(N2)
        int maxLen = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int zeroes = 0;
            for (int j = i; j < n; j++) {
                if(arr[j] == 0){
                    zeroes++;
                }
                if (zeroes <= k){
                    int len = j-i+1;
                    maxLen = Math.max(maxLen, len);
                }else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public static int optimalSolution1(int []arr, int k){
        //tc O(2N)
        int n = arr.length;
        int maxLen = 0;
        int l = 0, r = 0;
        int zeroes = 0;
        while (r < n){
            if(arr[r]==0) zeroes++;
            while (zeroes > k){
                if (arr[l] == 0) {
                    zeroes--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }


    public static int optimalSolution2(int []arr, int k){
        //tc O(N)
        int n = arr.length;
        int maxLen = 0;
        int l = 0, r = 0;
        int zeroes = 0;
        while (r < n){
            if(arr[r]==0) zeroes++;
            if (zeroes > k) {
                if (arr[l] == 0) {
                    zeroes--;
                }
                l++;
            }
            if (zeroes <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int []arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int answer = optimalSolution2(arr, k);
        System.out.println(answer);
    }
}
