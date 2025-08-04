import java.util.Stack;

public class infixToPrefix {

    // Function to reverse the string and swap parentheses
    public static String reverse(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ans = ')' + ans;
            } else if (ch == ')') {
                ans = '(' + ans;
            } else {
                ans = ch + ans;
            }
        }
        return ans;
    }

    // Function to return precedence of operators
    static int Prec(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '^') {
            return 3;
        }
        return -1;
    }

    // Function to convert infix to prefix
    public static String conversion(String s) {
        s = reverse(s); // Reverse the input string
        Stack<Character> stack = new Stack<>();
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is an operand
            if ((ch >= 'A' && ch <= 'Z') ||
                    (ch >= 'a' && ch <= 'z') ||
                    (ch >= '0' && ch <= '9')) {
                ans += ch;
            }
            // If the character is '('
            else if (ch == '(') {
                stack.push(ch);
            }
            // If the character is ')'
            else if (ch == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    ans += stack.pop();
                }
                stack.pop(); // Pop '('
            }
            // If the character is an operator
            else {
                while (!stack.empty() && Prec(ch) <= Prec(stack.peek())) {
                    ans += stack.pop();
                }
                stack.push(ch);
            }
        }

        // Pop all remaining operators from the stack
        while (!stack.empty()) {
            ans += stack.pop();
        }

        return reverse(ans); // Reverse the result to get the prefix
    }

    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        String ans = conversion(s);
        System.out.println(ans);
    }
}
