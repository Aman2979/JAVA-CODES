public class DP31 {
    public static String finalAnswer(String text1, String text2, int ind1, int ind2, int [][]dp) {
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

        StringBuilder sb = new StringBuilder();
        int i = ind1, j = ind2;
        while (i > 0 && j > 0){
            if (text1.charAt(i-1) == text2.charAt(j-1)) {
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                sb.append(text1.charAt(i-1));
                i--;
            }else {
                sb.append(text2.charAt(j-1));
                j--;
            }
        }

        // Store remaining characters
        while (i > 0){
            sb.append(text1.charAt(i-1));
            i--;
        }
        while (j > 0){
            sb.append(text2.charAt(j-1));
            j--;
        }


        // reverse the LCS string and return it
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "brute";
        String str2 = "groot";
        int ind1 = str1.length();
        int ind2 = str2.length();
        int [][]dp = new int[ind1+1][ind2+1];
        System.out.println(finalAnswer(str1, str2, ind1, ind2, dp));
    }
}
