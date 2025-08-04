import java.util.Arrays;

public class DP33 {
    public static int recursion(String word1,String word2, int i, int j){
        // Base cases...
        if (i < 0) return j+1;
        if (j < 0) return i+1;

        if (word1.charAt(i) == word2.charAt(j)){
            return recursion(word1, word2, i-1, j-1); // Or Same thing >> return 0 + recursion(word1, word2, i-1, j-1);
        }
        // Insert Operation >> f(i, j-1)
        // Delete Operation >> f(i-1, j)
        // Replace Operation >> f(i-1, j-1)
        return Math.min((1+recursion(word1, word2, i, j-1)),
                Math.min((1+recursion(word1, word2, i-1, j)),
                        (1+recursion(word1, word2, i-1, j-1))));
    }

    public static int memorization(String word1,String word2, int i, int j, int [][]dp){
        // Base cases...
        if (i < 0) return j+1;
        if (j < 0) return i+1;

        if (dp[i][j] != -1) return dp[i][j]; // Handle over lapping sub problems
        if (word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = memorization(word1, word2, i-1, j-1, dp);
        }

        return dp[i][j] = Math.min((1+memorization(word1, word2, i, j-1, dp)),
                Math.min((1+memorization(word1, word2, i-1, j, dp)),
                        (1+memorization(word1, word2, i-1, j-1, dp))));
    }

    public static int tabulation(String word1,String word2, int i, int j, int [][]dp) {
        for (int k = 0; k <= i; k++) dp[k][0] = k;
        for (int k = 0; k <= j; k++) dp[0][k] = k;
        for (int k = 1; k <= i; k++) {
            for (int l = 1; l <= j; l++) {
                if (word1.charAt(k-1) == word2.charAt(l-1)){
                    dp[k][l] = dp[k-1][l-1];
                }else{
                    dp[k][l] = Math.min((1+dp[k][l-1]),
                            Math.min((1+dp[k-1][l]), (1+dp[k-1][l-1])));
                }
            }
        }
        return dp[i][j];
    }

    public static int spaceOptimization(String word1, String word2, int i, int j) {
        int[] prev = new int[j + 1];
        int[] curr = new int[j + 1];

        for (int l = 0; l <= j; l++) {
            prev[l] = l; // Base case: converting "" to word2[0..l]
        }

        for (int k = 1; k <= i; k++) {
            curr[0] = k; // Base case: converting word1[0..k] to ""
            for (int l = 1; l <= j; l++) {
                if (word1.charAt(k - 1) == word2.charAt(l - 1)) {
                    curr[l] = prev[l - 1]; // No operation
                } else {
                    curr[l] = 1 + Math.min(
                            prev[l - 1],      // Replace
                            Math.min(
                                    prev[l],      // Delete
                                    curr[l - 1]   // Insert
                            )
                    );
                }
            }
            // Copy curr into prev for next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[j];
    }

    public static int helperFunction(String word1,String word2){
        int i = word1.length();
        int j = word2.length();
        int [][]dp = new int[i+1][j+1];
//        for (int []row : dp){
//            Arrays.fill(row, -1);
//        }
        return spaceOptimization(word1, word2, i, j);
    }
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(helperFunction(word1, word2));
    }
}
