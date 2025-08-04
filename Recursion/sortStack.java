import java.util.Arrays;
import java.util.Stack;

public class sortStack {
    public static Stack<Integer> sort(Stack<Integer> stack) {
        // Create a new stack to store the sorted elements
        Stack<Integer> ans = new Stack<>();
        int n = stack.size();  // Get the size of the input stack

        // Create an array to temporarily store the elements of the stack
        int[] arr = new int[n];

        // Pop all elements from the stack and store them in the array
        for (int i = 0; i < n; i++) {
            arr[i] = stack.peek();  // Get the top element
            stack.pop();            // Remove the top element
        }

        // Sort the array in ascending order
        Arrays.sort(arr);

        // Push the sorted elements back into the answer stack
        for (int i = 0; i < arr.length; i++) {
            ans.add(arr[i]);
        }

        // Return the sorted stack
        return ans;
    }

    public static void main(String[] args) {
        // Create and initialize the stack with unsorted elements
        Stack<Integer> stack = new Stack<>();
        stack.add(11);
        stack.add(3);
        stack.add(32);
        stack.add(2);
        stack.add(11);

        // Call the sort function to sort the stack
        Stack<Integer> ans = sort(stack);

        // Print the sorted stack
        System.out.println(ans);
    }
}

