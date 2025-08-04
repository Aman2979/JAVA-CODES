public class introduction {
    public static int simple(int number){
        return 1 + (number-1)%9;
    }
    public static void main(String[] args) {
        int number = 93;
        int answer = simple(number);
        System.out.println(answer);
    }
}
