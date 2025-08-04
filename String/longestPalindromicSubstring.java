public class longestPalindromicSubstring {

    /* Brute force Approach
    public static boolean Palindrome(String str){
        int left = 0;
        int right = str.length()-1;
        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int max_len = 1;
        String max_str = s.substring(0,1);
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                if(j-i > max_len && Palindrome(s.substring(i,j-i))) {
                    max_len = j - i;
                    max_str = s.substring(i, j - i);
                }
            }
        }
        return max_str;

     */


    //Optimal Approach
    public static String longestPalindrome(String s) {
        
        return "";
    }
    public static void main(String[] args) {
        String s = "babad";
        String myAnswer = longestPalindrome(s);
        System.out.println("The Ans is: "+myAnswer);
    }
}
