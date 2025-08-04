import java.util.Stack;

public class basicsSt {
    static class st {
        int top = -1;
        int size = 10;
        int[] arr = new int[size];

        void push(int x) {
            if (top < size - 1) { // Check for overflow
                top++;
                arr[top] = x;
            } else {
                System.out.println("Stack Overflow");
            }
        }

        int peek() { // Removed the parameter
            if (top >= 0) {
                return arr[top];
            } else {
                System.out.println("Stack Underflow");
                return -1; // Or throw an exception
            }
        }

        int pop() {
            if (top >= 0) {
                int x = arr[top];
                top--;
                return x;
            } else {
                System.out.println("Stack Underflow");
                return -1; // Or throw an exception
            }
        }

        int currentSize() { // Renamed method to avoid conflict
            return top + 1;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Perform stack operations
        stack.push(2);
        stack.push(2);
        stack.push(4);
        stack.push(1);

        System.out.println("Popped: " + stack.pop()); // Removes top element
        System.out.println("Top element (peek): " + stack.peek());
        System.out.println("Top element (peek): " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.push(5);
        System.out.println("Top element (peek): " + stack.peek());
        System.out.println("Stack size: " + stack.size());
    }

}
