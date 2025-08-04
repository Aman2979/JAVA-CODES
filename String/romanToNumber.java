import java.util.HashMap;

public class romanToNumber {
    public static void format(String s){
//        We are represent the roman numbers, following types..
//        Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int n = s.length();
        int romanNumber = 0;
        for (int i = 0; i < n; i++) {
            if(i<n-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                romanNumber += (map.get(s.charAt(i+1)) - map.get(s.charAt(i)));
                i++;
            }else {
                romanNumber += map.get(s.charAt(i));
            }
        }
        System.out.println(romanNumber);

    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        format(s);
    }
}
