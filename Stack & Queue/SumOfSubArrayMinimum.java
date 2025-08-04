//import java.util.Stack;
//
//public class SumOfSubArrayMinimum {
//    public static int [] nextSmallerElement(int []arr){
//        int n = arr.length;
//        int[] findNSE = new int[n];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            while (!stack.empty() && stack.peek() >= arr[i]){
//                stack.pop();
//            }
//            // If the stack is empty, there's no smaller element
//            if (stack.isEmpty()) {
//                findNSE[i] = n;
//            } else {
//                findNSE[i] = stack.peek();
//            }
//
//            // Push the current element into the stack
//            stack.push(i);
//        }
//        return findNSE;
//    }
//
//    public static int [] previousSmallerOrEqualToElement(int []arr){
//        int n = arr.length;
//        int[] findPSEE = new int[n];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            while (!stack.empty() && arr[stack.peek()] > arr[i]){
//                stack.pop();
//            }
//            // If the stack is empty, there's no smaller element
//            if (stack.isEmpty()) {
//                findPSEE[i] = -1;
//            } else {
//                findPSEE[i] = stack.peek();
//            }
//
//            // Push the current element into the stack
//            stack.push(i);
//        }
//        return findPSEE;
//    }
//    public static int sumSubArrayMinimum(int []arr){
//        int []nse = nextSmallerElement(arr);
//        int []pseE = previousSmallerOrEqualToElement(arr);
//        int total = 0;
//        int mod = (int)(1e9 + 7);
//        for (int i = 0; i < arr.length; i++) {
//            int left = i - pseE[i];
//            int right = nse[i] - i;
//            total = (total + (right * left *  arr[i])%mod)%mod;
//        }
//
//        return total;
//    }
//    public static void main(String[] args) {
//        int []arr = {11,81,94,43,3};
//        int ans = sumSubArrayMinimum(arr);
//        System.out.println(ans);
//    }
//}

import java.util.Stack;

public class SumOfSubArrayMinimum {

    public static int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] findNSE = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && arr[stack.peek()] > arr[i]) {
                findNSE[stack.pop()] = i; // Assign the next smaller index
            }
            stack.push(i);
        }

        // Remaining elements in stack have no smaller element on the right
        while (!stack.empty()) {
            findNSE[stack.pop()] = n; // Assign boundary value
        }

        return findNSE;
    }

    public static int[] previousSmallerOrEqualToElement(int[] arr) {
        int n = arr.length;
        int[] findPSEE = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // Assign previous smaller index (-1 if no smaller element exists)
            findPSEE[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return findPSEE;
    }

    public static int sumSubArrayMinimum(int[] arr) {
        int[] nse = nextSmallerElement(arr);
        int[] pseE = previousSmallerOrEqualToElement(arr);
        int total = 0;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < arr.length; i++) {
            int left = i - pseE[i];
            int right = nse[i] - i;
            total = (total + (right * left * arr[i]) % mod) % mod;
        }

        return total;
    }



    public static void main(String[] args) {
        int[] arr = {11, 81, 94, 43, 3};
        int ans = sumSubArrayMinimum(arr);
        System.out.println(ans); // Should print the correct sum
    }
}

