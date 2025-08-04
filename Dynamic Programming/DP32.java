import java.util.Arrays;
public class DP32 {
    public static int recursion(String s, String t, int i, int j){
        if (j < 0) return 1;
        if (i < 0) return 0;
        if (s.charAt(i) == t.charAt(j)){
            return recursion(s, t, i-1, j-1) + recursion(s, t, i-1, j);
        }
        return recursion(s, t, i-1, j);
    }

    public static int memorization(String s, String t, int i, int j, int [][]dp){
        if (j < 0) return 1;
        if (i < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == t.charAt(j)){
            return dp[i][j] = memorization(s, t, i-1, j-1, dp) + memorization(s, t, i-1, j, dp);
        }
        return dp[i][j] = memorization(s, t, i-1, j, dp);
    }

    public static int tabulation(String s, String t, int i, int j, int [][]dp){
        for (int k = 0; k <= i; k++) {
            dp[k][0] = 1;
        }
        for (int k = 1; k <= j; k++) {
            dp[0][k] = 0;
        }

        for (int k = 1; k <= i; k++) {
            for (int l = 1; l <= j; l++) {
                if (s.charAt(k-1) == t.charAt(l-1)){
                    dp[k][l] = dp[k-1][l-1] + dp[k-1][l];
                }else {
                    dp[k][l] = dp[k-1][l];
                }
            }
        }
        return dp[i][j];
    }

    public static int spaceOptimization(String s, String t, int i, int j){
        int []prev = new int[j+1];
        int []curr = new int[j+1];
        prev[0] = curr[0] = 1;

        for (int k = 1; k <= i; k++) {
            for (int l = 1; l <= j; l++) {
                if (s.charAt(k-1) == t.charAt(l-1)){
                    curr[l] = prev[l-1] + prev[l];
                }else {
                    curr[l] = prev[l];
                }
            }
            prev = curr;
        }
        return prev[j];
    }

    public static int helperFunction(String s, String t){
        int i = s.length();
        int j = t.length();
        int [][]dp = new int[i+1][j+1];
//        for (int []row : dp){
//            Arrays.fill(row,-1);
//        }
        return spaceOptimization(s, t, i, j);
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        System.out.println(helperFunction(s, t));
    }
}
