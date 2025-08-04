import java.util.Stack;

public class removeKthDigits {
    public String removeKDigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        // Iterate through each digit
        for (int i = 0; i < num.length(); i++) {
            char currentDigit = num.charAt(i);

            // Remove digits from the stack if they are larger than the current digit
            // And we still need to remove more digits
            while (!stack.isEmpty() && k > 0 && stack.peek() > currentDigit) {
                stack.pop();
                k--;
            }

            // Push the current digit to the stack
            stack.push(currentDigit);
        }

        // Remove remaining digits if `k` is still greater than 0
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build the result string from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        // Return the result or "0" if empty
        if (result.isEmpty()){
            return "0";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        removeKthDigits solution = new removeKthDigits();
        String num = "1432219";
        int k = 3;

        // Example test case
        System.out.println("Result: " + solution.removeKDigits(num, k)); // Expected: "1219"
    }
}
