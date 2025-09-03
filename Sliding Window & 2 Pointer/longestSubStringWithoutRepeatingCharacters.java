import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longestSubStringWithoutRepeatingCharacters {
    public static int longestSubString(String s){
        int n = s.length();
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            int []hash = new int[124];
            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] == 1) break;
                maxi = Math.max(maxi, j-i+1);
                hash[s.charAt(j)] = 1;
                System.out.print((int) s.charAt(j) + " ");
            }
        }
        System.out.println();
        return maxi;
    }

    public static int longestSubString1(String s){
        int n = s.length();
        int maxi = 0;
        int l = 0;
        int r = 0;
        int []hash = new int[124];
        Arrays.fill(hash,-1);
        while (r < n){
            if (hash[s.charAt(r)] != -1){
                if (hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)]+1;
                }
            }
            maxi = Math.max(maxi, r-l+1);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxi;
    }
    public static void main(String[] args) {
        String s = "abcddacebac";
        System.out.println(longestSubString1(s));
    }
}
