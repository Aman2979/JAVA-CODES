import java.util.Arrays;

public class DP25 {
    public static int recursion(String text1, String text2,int ind1, int ind2) {
        if (ind1 < 0 || ind2 < 0) return 0;
        if (text1.charAt(ind1) == text2.charAt(ind2)){
            return 1 + recursion(text1, text2, ind1-1, ind2-1);
        }
        return Math.max(recursion(text1, text2, ind1-1, ind2),
                recursion(text1, text2, ind1, ind2-1));
    }

    public static int memorization(String text1, String text2,int ind1, int ind2, int [][]dp) {
        if (ind1 < 0 || ind2 < 0) return 0;
        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if (text1.charAt(ind1) == text2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + memorization(text1, text2, ind1-1, ind2-1, dp);
        }
        return dp[ind1][ind2] = Math.max(memorization(text1, text2, ind1-1, ind2, dp),
                memorization(text1, text2, ind1, ind2-1, dp));
    }

    public static int tabulation(String text1, String text2,int ind1, int ind2, int [][]dp) {
        for (int j = 0; j <= ind2; j++) dp[0][j] = 0;
        for (int i = 0; i <= ind1; i++) dp[i][0] = 0;
        for (int i = 1; i <= ind1; i++) {
            for (int j = 1; j <= ind2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[ind1][ind2];
    }

    public static int spaceOptimization(String text1, String text2,int ind1, int ind2,int []prev, int[]curr) {
        for (int j = 0; j <= ind2; j++) prev[j] = 0;
        for (int i = 1; i <= ind1; i++) {
            for (int j = 1; j <= ind2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
                prev = curr;
            }
        }
        return prev[ind2];
    }

    public static int helperFunction(String text1, String text2){
        int ind1 = text1.length();
        int ind2 = text2.length();
        int [][]dp = new int[ind1+1][ind2+1];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }

        // for space Optimization

        int []prev = new int[ind2+1];
        int []curr = new int[ind2+1];
        return spaceOptimization(text1, text2, ind1, ind2, prev, curr);
    }
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(helperFunction(text1, text2));
    }
}
