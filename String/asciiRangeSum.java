import java.util.ArrayList;

public class asciiRangeSum {
    public static int calculate(String temp){
        int asciiValue = 0;
        for (int i = 0; i < temp.length(); i++) {
            asciiValue += (int)temp.charAt(i);
        }
        return asciiValue;
    }

    public static ArrayList<Integer> asciiRange(String s){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);

            if (i == first && first != last) {
                int start = first + 1;
                int end = last;
                if (start < end) {
                    String temp = s.substring(start, end);
                    int oneAns = calculate(temp);
                    if (oneAns > 0) {
                        ans.add(oneAns);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abacab";
        System.out.println(asciiRange(s));
    }
}
