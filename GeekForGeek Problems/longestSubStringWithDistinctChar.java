import java.util.*;

public class longestSubStringWithDistinctChar {
    private static int longestUniqueSubStr(String s){
        if(s.length()==0) {
            return 0;
        }
        int maxans = Integer.MIN_VALUE;
        Set < Character > set = new HashSet < > ();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (set.contains(s.charAt(r))){
                while (l < r && set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;
    }
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        int ans = longestUniqueSubStr(s);
        System.out.println(ans);
    }
}
