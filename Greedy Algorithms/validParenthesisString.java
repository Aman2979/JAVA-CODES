public class validParenthesisString {
    private static boolean helperFunction(String s, int index, int count){
        if (count < 0){
            return false;
        }
        if (index == s.length()){
            return (count == 0);
        }
        if (s.charAt(index) == '('){
            return helperFunction(s, index+1, count+1);
        }
        if (s.charAt(index) == ')'){
            return helperFunction(s, index+1, count-1);
        }
        return  helperFunction(s, index+1, count+1) ||
                helperFunction(s, index+1, count-1) ||
                helperFunction(s, index+1, count);
    }
    private static boolean checkValid(String s){
        // TC = O(3^N) SC = O(N)
        return helperFunction(s, 0, 0);
    }

    private static boolean optimalSolution(String s){
        // TC = O(N), SC = O(1)
        int min = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                min += 1;
                max += 1;
            } else if (s.charAt(i) == ')') {
                min -= 1;
                max -= 1;
            }else {
                min -= 1;
                max += 1;
            }
            if (min < 0) min = 0;
            if (max < 0) return false;
        }
        return (min == 0);
    }
    public static void main(String[] args) {
        String s = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";
        boolean ans = optimalSolution(s);
        System.out.println(ans);
    }
}
