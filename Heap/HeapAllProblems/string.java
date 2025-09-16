public class string {
    public static String recursion(String s, String ans, int n, int ind){
        // Base Case Think latter
        if (ind >= n) return ans;

        // Actual logic
        if (s.charAt(ind) != ' '){
            ans += s.charAt(ind);
        }
        return recursion(s, ans, n, ind+1);
    }
    public static String helper(String s){
        String ans = "";
        int n = s.length();
        return recursion(s, ans, n, 0);
    }
    public static void main(String[] args) {
        String s = "1023948765";
        System.out.println(helper(s));
    }
}
