import java.util.Arrays;
import java.util.Stack;

public class nextSmaller {

//    Brute force Solution
//    public static int [] nextSmallerElement(int []arr){
//        int n = arr.length;
//        int[] nSE = new int[n];
//        for (int i = 0; i < n; i++) {
//            nSE[i] = -1;
//            for (int j = i-1; j >= 0; j--) {
//                if (arr[j] < arr[i]){
//                    nSE[i] = arr[j];
//                    break;
//                }
//            }
//        }
//        return nSE;
//    }

    public static int [] nextSmallerElement(int []arr){
        int n = arr.length;
        int[] findNSE = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            // If the stack is empty, there's no smaller element
            if (stack.isEmpty()) {
                findNSE[i] = -1;
            } else {
                findNSE[i] = stack.peek();
            }

            // Push the current element into the stack
            stack.push(arr[i]);
        }
        return findNSE;
    }

    public static void main(String[] args) {
        int []arr = {4, 5, 2, 10, 8};
        int [] ans = nextSmallerElement(arr);
        System.out.println(Arrays.toString(ans));
    }
}
