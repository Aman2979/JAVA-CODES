import java.util.HashMap;

public class longestSubArray0sAnd1s {
    private static int myCode(int [] arr){
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int cnt0 =0, cnt1=0;
            for (int j = i; j < n; j++) {
                if(arr[j] == 1){
                    cnt1++;
                } else if (arr[j] == 0) {
                    cnt0++;
                }
                if (cnt0 == cnt1){
                    maxLen = Math.max(maxLen, cnt1+cnt0);
                }
            }
        }
        return maxLen;
    }

    private static int OptimalCode(int [] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0){
                sum += -1;
            }else {
                sum += 1;
            }

            if (sum == 0){
                maxLen = i+1;
            }

            if (map.containsKey(sum)){
                maxLen = Math.max(maxLen,i - map.get(sum));
            }else {
                map.put(sum,i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int []arr = {1, 0, 1, 1, 1, 0, 0};
        int answer = OptimalCode(arr);
        System.out.println(answer);
    }
}
