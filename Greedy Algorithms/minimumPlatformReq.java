import java.util.Arrays;

public class minimumPlatformReq {
    public static int findMin(int []arr, int []dep){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int n = arr.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int maxPlatform = 0;
        while (i < n){
            if (arr[i] <= dep[j]){
                count++;
                i++;
            }else {
                count--;
                j++;
            }
            maxPlatform = Math.max(maxPlatform, count);
        }
        return maxPlatform;
    }
    public static void main(String[] args) {
        int []arr = {900, 940, 950, 1100, 1500, 1800};
        int []dep = {910, 1200, 1120, 1130, 1900, 2000};

        int answer = findMin(arr, dep);
        System.out.println(answer);
    }
}
