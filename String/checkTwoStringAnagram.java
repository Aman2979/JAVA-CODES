import java.util.Arrays;

public class checkTwoStringAnagram {
    public static boolean isAnagram(String s, String t) {
        char []a1 = s.toCharArray();
        char []b1 = t.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b1);

        if(a1.length != b1.length){
            return false;
        }
        for (int i = 0; i < a1.length; i++) {
            if(a1[i] != b1[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        boolean res = isAnagram("anagram","nagaram");
        System.out.println(res);
    }
}
