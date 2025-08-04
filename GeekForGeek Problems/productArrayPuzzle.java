import java.util.Arrays;

public class productArrayPuzzle {
    public static int[] optimizeCode(int []arr){
        int n = arr.length;
        int[] res = new int[n];

        //Step 1
        int [] leftProduct = new int[n];
        leftProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i-1]*arr[i-1];
        }

        //Step 2
        int rightProduct = 1;
        for (int i = n-1; i >= 0; i--) {
            res[i] = leftProduct[i]*rightProduct;
            rightProduct *= arr[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int []arr = {12, 0, 1 , 3, 4, 0};
        int []answer = optimizeCode(arr);
        System.out.println(Arrays.toString(answer));
    }
}
