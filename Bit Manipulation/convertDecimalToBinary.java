public class convertDecimalToBinary {
    public static String decimalToBinary(int number){
        String res = "";
        while (number > 0){
            if (number%2 == 1) {
                res += "1";
            }else {
                res += "0";
            }
            number = number/2;
        }

        String ansString = "";
        for (int i = 0; i < res.length(); i++) {
            ansString = res.charAt(i) + ansString;
        }
        return ansString;
    }
    public static void main(String[] args) {
        int number = 18;
        String answer = decimalToBinary(number);
        System.out.println(answer);
    }
}
