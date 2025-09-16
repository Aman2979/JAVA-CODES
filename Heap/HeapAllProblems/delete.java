public class delete {
    public static int helper(int []arr){
        if (arr[0] == 0) return -1;
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= arr.length-1) return ans;
            int maxi = -1;
            for (int j = i; j <= arr[i]; j++) {
                if (maxi < arr[j]){
                    maxi = arr[i];
                }
            }
            ans++;
            if (maxi != -1){
                i = maxi;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int []arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(helper(arr));
    }
}
