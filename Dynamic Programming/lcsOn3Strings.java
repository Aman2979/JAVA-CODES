import java.util.Arrays;

public class lcsOn3Strings {
    public static int recursion(String s1, String s2, String s3, int i, int j, int k, int[][][] dp) {
        if (i == 0 || j == 0 || k == 0) return 0;
        if (dp[i][j][k] != -1) return dp[i][j][k];
        if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)) {
            return dp[i][j][k] = 1 + recursion(s1, s2, s3, i - 1, j - 1, k - 1, dp);
        }
        return dp[i][j][k] = Math.max(
                recursion(s1, s2, s3, i - 1, j, k, dp),
                Math.max(
                        recursion(s1, s2, s3, i, j - 1, k, dp),
                        recursion(s1, s2, s3, i, j, k - 1, dp)
                ));
    }

    public static int helperFunction(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        int [][][]dp = new int[len1 + 1][len2 + 1][len3 + 1];
        for (int[][] mat : dp){
            for (int[] row : mat){
                Arrays.fill(row, -1);
            }
        }

        return recursion(s1, s2, s3, len1, len2, len3, dp);
    }
    public static void main(String[] args) {
        String s1 = "Aman";
        String s2 = "Aman";
        String s3 = "Aman";
        System.out.println(helperFunction(s1, s2, s3));
    }
}
