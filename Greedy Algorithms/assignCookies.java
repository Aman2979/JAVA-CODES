import java.util.Arrays;

public class assignCookies {
    public static int findMaximumPath(int []g, int []s){
        int n = g.length;
        int m = s.length;
        int left = 0;
        int right = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (left < m){
            if (g[right] <= s[left]){
                right++;
            }
            left++;
        }
        return right;
    }
    public static void main(String[] args) {
        int []g = {1, 2, 3};
        int []s = {1, 3, 2};
        int ans = findMaximumPath(g, s);
        System.out.println(ans);
    }
}
