public class maximumDepth {
    public static int maxDepth(String s){
        int n = s.length();
        int count = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '('){
                count++;
                res = Math.max(res,count);
            }
            if( s.charAt(i) == ')'){
                count--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
       String s = "(1+(2*3)+((8)/4))+1+((((()))))";
       int result = maxDepth(s);
        System.out.println(result);
    }
}
