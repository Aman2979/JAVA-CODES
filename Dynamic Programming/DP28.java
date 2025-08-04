import java.util.Arrays;

public class DP28 {
    public static int recursion(String s1, String s2,int ind1, int ind2) {
        if (ind1 < 0 || ind2 < 0) return 0;
        if (s1.charAt(ind1) == s2.charAt(ind2)){
            return 1 + recursion(s1, s2, ind1-1, ind2-1);
        }
        return Math.max(recursion(s1, s2, ind1-1, ind2),
                recursion(s1, s2, ind1, ind2-1));
    }

    public static int memorization(String s1, String s2,int ind1, int ind2, int [][]dp) {
        if (ind1 < 0 || ind2 < 0) return 0;
        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if (s1.charAt(ind1) == s2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + memorization(s1, s2, ind1-1, ind2-1, dp);
        }
        return dp[ind1][ind2] = Math.max(memorization(s1, s2, ind1-1, ind2, dp),
                memorization(s1, s2, ind1, ind2-1, dp));
    }

    public static int tabulation(String s1, String s2,int ind1, int ind2, int [][]dp) {
        for (int j = 0; j <= ind2; j++) dp[0][j] = 0;
        for (int i = 0; i <= ind1; i++) dp[i][0] = 0;
        for (int i = 1; i <= ind1; i++) {
            for (int j = 1; j <= ind2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[ind1][ind2];
    }

    public static int helperFunction(String s1){
        String s2 = "";
        for (int i = s1.length()-1; i >= 0; i--) {
            s2 = s2 + s1.charAt(i);
        }
        int ind1 = s1.length();
        int ind2 = s2.length();
        int [][]dp = new int[ind1+1][ind2+1];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        return tabulation(s1, s2, ind1-1, ind2-1, dp);
    }
    public static void main(String[] args) {
        String s = "mand";
        System.out.println(helperFunction(s));
    }
}
