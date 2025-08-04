import java.util.Arrays;
import java.util.Stack;

public class nextGreater2 {
//    public static int[] nextGreaterElements(int[] arr) {
//        int n = arr.length;
//        int []nge = new int[n];
//        for (int i = 0; i < n; i++) {
//            nge[i] = -1;
//            for (int j = i+1; j < i+n; j++) {
//                int index = j % n;
//                if (arr[index] > arr[i]){
//                    nge[i] = arr[index];
//                    break;
//                }
//            }
//        }
//        return nge;
//    }

    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int [] findNGE = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2*n-1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= arr[i%n]){
                stack.pop();
            }
            if (i < n){
                findNGE[i] = stack.empty() ? -1 : stack.peek();
            }
            stack.push(arr[i % n]);
        }
        return findNGE;
    }
    public static void main(String[] args) {
        int []arr = {4, 13, 6, 4, 2, 3, 4, 5, 1, 2, 3,};
        int []ans = nextGreaterElements(arr);
        System.out.println(Arrays.toString(ans));
    }
}
