public class subArrayWithGivenSumK {
//    public static int find(int[] arr, int k){
//        int cnt = 0;
//        int n = arr.length;
//        for (int i = 0;i<n;i++){
//            for (int j = i; j < n; j++) {
//                int sum = 0;
//                for (int K = i; K < j; K++) {
//                    sum += arr[K];
//                    }
//
//                if (sum == k){
//                    cnt++;
//                }
//            }
//        }
//        return cnt;
//    }

    public static int find(int[] arr, int k){
        int cnt = 0;
        int n = arr.length;
        for (int i = 0;i<n;i++){
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int k = 3;
        int []arr = {1,2,3};

        int answer = find(arr, k);
        System.out.println(answer);
    }
}
