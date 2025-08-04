public class isPalindrome {
    public static Boolean palindrome(String input1){
        String input = input1.toLowerCase();
        int first = 0;
        int end = input.length()-1;
        while (first<end){
            char curFirst = input.charAt(first);
            char curEnd = input.charAt(end);
            if(!Character.isLetterOrDigit(curFirst)){
                first++;
            } else if (!Character.isLetterOrDigit(curEnd)) {
                end--;
            }
            if(input.charAt(first) != input.charAt(end)){
                return false;
            }
            first++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        Boolean result = palindrome("");
        System.out.println(result);
    }
}
