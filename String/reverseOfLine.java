import java.util.*;
public class reverseOfLine {
    public static String reverseWord(String s) {
        StringBuilder res = new StringBuilder();
        int startIndex = s.length()-1;
        while (startIndex >= 0) {
            while (startIndex >= 0 && s.charAt(startIndex) == ' ') {
                startIndex--;
            }
            if(startIndex < 0){
                break;
            }
            int endIndex = startIndex;
            while (startIndex >= 0 && s.charAt(startIndex) != ' '){
                startIndex--;
            }
            if(res.isEmpty()){
                res.append(s.substring(startIndex+1,endIndex+1));
            }else {
                res.append(" ");
                res.append(s.substring(startIndex+1,endIndex+1));
            }
        }
        return s.toString();
    }
    public static void main(String[] args) {
        String s = "the sky is blue";
        reverseWord(s);
    }
}
