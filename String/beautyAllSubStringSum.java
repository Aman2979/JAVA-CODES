public class beautyAllSubStringSum {
    public static int getMin(int []hash) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                min = Math.min(min, hash[i]);
            }
        }
        return min;
    }

    public static int getMax(int []hash) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, hash[i]);
        }
        return max;
    }

    public static int find(String s){
        if (s.length() <= 2) return 0;
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int []hash = new int[26];
            for (int j = i; j < n; j++) {
                hash[s.charAt(j) - 'a']++;
                int diff = getMax(hash) - getMin(hash);
                if (diff > 0){
                    ans += diff;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabcbaa";
        System.out.println(find(s));
    }
}
