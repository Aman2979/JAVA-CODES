public class isPalindrome {
    static boolean print(String s, int i){
        if (i >= s.length()/2) return true;
        if (s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        return print(s, i+1);
    }
    public static void main(String[] args) {
        String s = "MADA";
        System.out.println(print(s,0));
    }
}
