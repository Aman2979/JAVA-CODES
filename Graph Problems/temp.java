public class temp {
    public static boolean isPossible(int []arr, int k){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < k; j++) {
                if(arr[j] > arr[j+1]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int []arr = {1, 1, 1, 1, 1};
        int k = 4;
        System.out.println(isPossible(arr, k));
    }
}
