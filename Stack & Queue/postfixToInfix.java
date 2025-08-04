import java.util.Stack;
public class postfixToInfix {
    public static String conversion(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            // Check if character is an operand
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                // Operator: pop two operands
                String operand2 = stack.pop(); // Second operand (right-hand side)
                String operand1 = stack.pop(); // First operand (left-hand side)
                // Form the new infix expression
                String result = "(" + operand1 + ch + operand2 + ")";
                stack.push(result);
            }
            i++;
        }
        // The result should be the only element left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "abcd^e-fgh*+^*+i-"; // Example postfix expression
        String infix = conversion(postfix);
        System.out.println("Infix expression: " + infix);
    }
}

