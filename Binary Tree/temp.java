public class temp {
    public static boolean canBeTypedWords(String pat, String tar) {
       int n = pat.length();
       int m = tar.length();
       int i = 0;
       int j = 0;

       while (i < n && j < m){
           if (pat.charAt(i) == tar.charAt(j)){
               i++;
               j++;
           }else {
               i++;
           }
       }
        return j == m;
    }
    public static void main(String[] args) {
        String pat = "ufahs";
        String tar = "aus";
        System.out.println(canBeTypedWords(pat, tar));
    }
}
