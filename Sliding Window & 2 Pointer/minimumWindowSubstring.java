import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstring {
    public static String bruteSolution(String s, String t) {
        int n = s.length();
        int m = t.length();
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                map.put(t.charAt(j),map.getOrDefault(t.charAt(j),0)+1);
                for (int k = 0; k < n; k++) {
                    if (map.get(s.charAt(k)) > 0){
                        count++;
                    }
                    map.put(s.charAt(k), map.get(s.charAt(k))-1);
                    if (count == m){
                        if (k-i+1 < minLen){
                            minLen = k - i +1;
                            startIndex = i;
                            break;
                        }
                    }
                }
            }
        }
        return s.substring(startIndex,minLen);
    }

    public static String optimalSolution(String s, String t) {
        if (s.length() < t.length()) return ""; // Edge case

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, startIndex = -1;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                if (map.get(rightChar) >= 1) count--; // Only decrease for required characters
                map.put(rightChar, map.get(rightChar) - 1);
            }

            while (count == 0) { // Valid window found
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count++; // Only increase when we lose a necessary character
                }
                left++; // Shrink window
            }

            right++; // Expand window
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String answer = optimalSolution(s, t);
        System.out.println(answer);
    }
}
