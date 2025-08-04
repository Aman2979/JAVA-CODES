import java.util.HashMap;

public class longestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int n = s.length();
        int maxCount = 0;
        int maxLen = 0;
        int[] charCount = new int[26];

        while (right < s.length()) {
            charCount[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxCount > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        int answer = characterReplacement(s, k);
        System.out.println(answer);
    }
}
