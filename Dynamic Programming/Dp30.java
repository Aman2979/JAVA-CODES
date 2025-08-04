import java.util.Arrays;

public class Dp30 {
    public static int recursion(String word1, String word2, int ind1, int ind2){
        // first we find >>> LCS
        if (ind1 < 0 || ind2 < 0) return 0;
        if (word1.charAt(ind1) == word2.charAt(ind2)){
            return 1 + recursion(word1, word2, ind1 - 1, ind2-1);
        }

        return Math.max(recursion(word1, word2, ind1 - 1, ind2),
                recursion(word1, word2, ind1, ind2-1));
    }

    public static int memorization(String word1, String word2, int ind1, int ind2, int [][]dp){
        // first we find >>> LCS
        if (ind1 < 0 || ind2 < 0) return 0;
        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if (word1.charAt(ind1) == word2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + memorization(word1, word2, ind1 - 1, ind2-1, dp);
        }

        return dp[ind1][ind2] = Math.max(memorization(word1, word2, ind1 - 1, ind2, dp),
                memorization(word1, word2, ind1, ind2-1, dp));
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

    public static int helperFunction(String word1, String word2){
        int ind1 = word1.length();
        int ind2 = word2.length();

        int [][]dp = new int[ind1+1][ind2+1];
        for (int []row : dp){
            Arrays.fill(row, -1);
        }
        int lcs = tabulation(word1, word2, ind1, ind2, dp);
        return (ind1 - lcs) + (ind2 - lcs);
    }


    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(helperFunction(word1, word2));
    }
}
