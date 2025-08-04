import java.util.ArrayList;
import java.util.List;

public class palindromePartitioning {
    public static List<List<String>> mainFunctionPartition(String s) {
        List<List<String>> ansList = new ArrayList<>();
        List<String> path = new ArrayList<>();
        recursiveFunc(0,s,path,ansList);
        return ansList;
    }

    private static void recursiveFunc(int index,String s, List<String> path, List<List<String>> ansList){
        if (index == s.length()){
            ansList.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                recursiveFunc(i+1,s, path,ansList);
                path.remove(path.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start,int end){
        while (start <= end){
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "nitin";
        List<List<String>> answer = mainFunctionPartition(s);
        System.out.println(answer);
    }
}
