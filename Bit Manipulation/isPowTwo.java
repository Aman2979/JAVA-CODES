public class isPowTwo {
    public static void main(String[] args) {
        int number = 16;
        if ((number & (number - 1)) == 0){
            System.out.println("Yes");
        }else {
            System.out.println("Not");
        }
    }
}
