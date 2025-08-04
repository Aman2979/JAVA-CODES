import java.util.Arrays;

public class DP34 {
    public static boolean recursion(String str, String pattern, int i, int j) {
        // Base cases
        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (pattern.charAt(k) != '*') return false;
            }
            return true;
        }

        if (pattern.charAt(j) == str.charAt(i) || pattern.charAt(j) == '?') {
            return recursion(str, pattern, i - 1, j - 1);
        }

        if (pattern.charAt(j) == '*') {
            // '*' can match empty (j-1) or any char (i-1)
            return recursion(str, pattern, i - 1, j) || recursion(str, pattern, i, j - 1);
        }

        return false;
    }


    // Helper function to check if all characters from 0 to i in pattern are '*'
    static boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
            if (S1.charAt(j) != '*')
                return false;
        }
        return true;
    }

    // Memoization function
    static int memorization(String S1, String S2, int i, int j, int[][] dp) {
        if (i < 0 && j < 0)
            return 1;
        if (i < 0 && j >= 0)
            return 0;
        if (j < 0 && i >= 0)
            return isAllStars(S1, i) ? 1 : 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?') {
            return dp[i][j] = memorization(S1, S2, i - 1, j - 1, dp);
        }

        if (S1.charAt(i) == '*') {
            return dp[i][j] = (memorization(S1, S2, i - 1, j, dp) == 1 || memorization(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
        }

        return dp[i][j] = 0;
    }

    public static boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        return memorization(p, s, n - 1, m - 1, dp) == 1;
    }

    public static void main(String[] args) {
        String p = "cb";
        String s = "?*"; // S has >>> * or ?
        boolean ans = isMatch(s, p);
        System.out.println(ans);
    }
}
