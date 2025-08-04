import java.util.Stack;

public class balancedParenthesis {
    public static boolean string(String s){
        Stack<Character> st = new Stack<Character>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '[' || it == '{')
                st.push(it);
            else {
                if(st.isEmpty()) return false;
                char ch = st.pop();
                if((it == ')' && ch == '(') ||  (it == ']' && ch == '[') || (it == '}' && ch == '{')) continue;
                else return false;
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        String s = "()[]{";
        boolean ans = string(s);
        System.out.println(ans);
    }
}
