import java.util.Arrays;

public class DP26 {
    public static void tabulation(String text1, String text2,int ind1, int ind2, int [][]dp) {
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

        int len=dp[ind1][ind2];
        int i=ind1;
        int j=ind2;

        int index = len-1;
        String str="";
        for(int k=1; k<=len;k++){
            str += "$"; // dummy string
        }
        StringBuilder ss= new StringBuilder(text1);
        StringBuilder str2=new StringBuilder(str);
        while(i>0 && j>0){
            if(ss.charAt(i-1) == text2.charAt(j-1)){
                str2.setCharAt(index,ss.charAt(i-1) );
                index--;
                i--;
                j--;
            }
            else if(ss.charAt(i-1)>text2.charAt(j-1)){
                i--;
            }
            else j--;
        }
        System.out.println(str2);
    }

    public static void helperFunction(String text1, String text2){
        int ind1 = text1.length();
        int ind2 = text2.length();
        int [][]dp = new int[ind1+1][ind2+1];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        tabulation(text1, text2, ind1, ind2,dp);
    }

    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";
        helperFunction(str1,str2);
    }
}
