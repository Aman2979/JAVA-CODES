import java.util.ArrayList;
import java.util.List;

public class rabinKarpAlgo {
    public static List<Integer> findIndexes(String txt, String pat){
        List<Integer> ans = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        for (int i = 0; i <= n-m; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (pat.charAt(j) != txt.charAt(j+i)){
                    flag = false;
                    break;
                }
            }
            if (flag) ans.add(i);
        }
        return ans;
    }


    public static List<Integer> optimal(String pat, String txt) {
        int n = pat.length();
        int m = txt.length();
        int p = 7, mod = 101;
        int hashPat = 0, hashText = 0;
        int pRight = 1, pLeft = 1;
        for (int i = 0; i < n; i++) {
            hashPat = (hashPat + ((pat.charAt(i) - 'a' + 1) * pRight) % mod) % mod;
            hashText = (hashText + ((txt.charAt(i) - 'a' + 1) * pRight) % mod) % mod;
            pRight = (pRight * p) % mod;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= m - n; i++) {
            if (hashPat == hashText) {
                if (txt.substring(i, i + n).equals(pat)) ans.add(i);
            }

            if (i < m - n) {
                hashText = (hashText - ((txt.charAt(i) - 'a' + 1) * pLeft) % mod + mod) % mod;
                hashText = (hashText + ((txt.charAt(i + n) - 'a' + 1) * pRight) % mod) % mod;
                hashPat = (hashPat * p) % mod;

                pLeft = (pLeft * p) % mod;
                pRight = (pRight * p) % mod;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String txt = "abdabfab";
        String pat = "ab";
        System.out.println(optimal(pat, txt));
    }
}
