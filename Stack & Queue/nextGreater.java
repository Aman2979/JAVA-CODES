import java.util.Arrays;
import java.util.Stack;

public class nextGreater {

    //Brute force Solution.
//    public static int [] nGE(int []arr){
//        int n = arr.length;
//        int []nge = new int[n];
//        for (int i = 0; i < n; i++) {
//            nge[i] = -1;
//            for (int j = i+1; j < n; j++) {
//                if (arr[j] > arr[i]){
//                    nge[i] = arr[j];
//                    break;
//                }
//            }
//        }
//        return nge;
//    }

    public static int [] nGE(int []arr){
        int n = arr.length;
        int [] findNGE = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if (stack.empty()){
                findNGE[i] = -1;
            }else {
                findNGE[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return findNGE;
    }
    public static void main(String[] args) {
        int []arr = {4, 13, 6, 4, 2, 3, 4, 5, 1, 2, 3,};
        int []ans = nGE(arr);
        System.out.println(Arrays.toString(ans));
    }
}
