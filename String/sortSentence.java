import java.util.HashMap;
import java.util.*;

public class sortSentence {
    public static String sort(String s) {
        HashMap<Integer,String> res = new HashMap<>();
        for (String word : s.split(" ")){
            int lastIndex = word.length() - 1;
            int index = word.charAt(lastIndex);
            String actualWord = word.substring(0, lastIndex);
            res.put(index, actualWord);
        }
        StringBuilder actualString = new StringBuilder();
        for (Map.Entry<Integer, String> indexWord : res.entrySet()){
            actualString.append(indexWord.getValue());
            actualString.append(" ");
        }
        return actualString.toString().trim();
    }
    public static void main(String[] args) {
        String s = "Myself2 Me1 I4 and3";
        String answer = sort(s);
        System.out.println(answer);
    }
}
