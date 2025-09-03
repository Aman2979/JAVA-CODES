import java.util.HashMap;
import java.util.Map;

public class longestSubStringAtMostKDistinctCharacters {
    public static int brute(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
                if (map.size() <= k){
                    maxLen = Math.max(maxLen, j-i+1);
                }else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public static int optimal(String s, int k){
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxLen = 0;
        int l = 0;
        int r = 0;
        while (r < n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            while (map.size() > k){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)-1);
                if (map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if (map.size() <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }

    public static int mostOptimal(String s, int k){
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxLen = 0;
        int l = 0;
        int r = 0;
        while (r < n){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            if (map.size() > k){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)-1);
                if (map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if (map.size() <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "abcddefg";
        System.out.println(mostOptimal(s, 3));
    }
}
