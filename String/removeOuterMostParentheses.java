import java.util.*;
public class removeOuterMostParentheses {
    public static String format(String s){
         int count = 0;
         String ans = "";
         boolean flag = true;
         for(int i = 0; i < s.length();i++){
             if(s.charAt(i) == '('){
                 count++;
             }else if(s.charAt(i) == ')'){
                 count--;
             }
             if(count == 1 && flag == true){
                 flag = false;
                 continue;
             }
             if(count == 0 && flag == false){
                 flag = true;
                 continue;
             }
             ans += s.charAt(i);
         }
         return ans;
    }

    public static void main(String[] args) {
        String s = "(()())(())(())";
        String ans = format(s);
        System.out.println(ans);
    }
}
