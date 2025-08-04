//import java.util.Stack;
//
//public class infixToPostfix {
//    static int Prec(char ch) {
//        switch (ch) {
//            case '+':
//            case '-':
//                return 1;
//
//            case '*':
//            case '/':
//                return 2;
//
//            case '^':
//                return 3;
//        }
//        return -1;
//    }
//
//    public static String conversion(String s){
//        Stack<Character> stack = new Stack<>();
//        String ans = "";
//        int i = 0;
//        while (i < s.length()){
//            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||
//                    (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
//                    (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
//                ans += s.charAt(i); // Append operand directly to result
//            } else if(s.charAt(i) == '('){
//                stack.push(s.charAt(i));
//            }else if (s.charAt(i) == ')'){
//                while (stack.empty() && stack.peek() != '('){
//                    ans += stack.peek();
//                    stack.pop();
//                }
//                stack.pop();
//            }else {
//                while (stack.empty() && Prec(s.charAt(i)) <= Prec(s.charAt(i))){
//                    ans += stack.peek();
//                    stack.pop();
//                }
//                stack.push(s.charAt(i));
//            }
//            i++;
//        }
//        while (!stack.empty()){
//            ans += stack.peek();
//            stack.pop();
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
//        String s = "a+b*(c^d-e)^(f+g*h)-i";
//        String ans = conversion(s);
//        System.out.println(ans);
//    }
//}


import java.util.Stack;

public class infixToPostfix {
    static int Prec(char ch) {
//        switch (ch) {
//            case '+':
//            case '-':
//                return 1;
//            case '*':
//            case '/':
//                return 2;
//            case '^':
//                return 3;
//        }

        if(ch == '+' || ch == '-'){
            return 1;
        }else if(ch == '*' || ch == '/'){
            return 2;
        } else if (ch == '^') {
            return 3;
        }
        return -1;
    }

    public static String conversion(String s) {
        Stack<Character> stack = new Stack<>();
        String ans = "";
        int i = 0;
        while (i < s.length()) {
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
            i++;
        }

        // Pop all the operators from the stack
        while (!stack.empty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        String ans = conversion(s);
        System.out.println(ans); // Expected output: abcd^e-fgh*+^*+i-
    }
}

