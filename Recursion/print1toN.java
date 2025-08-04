import java.util.Scanner;

public class print1toN {
    static void print(int i, int num){
        if (i > num){
            return;
        }

        System.out.print(i+" ");
        print(i+1, num);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the number: ");
        int num = sc.nextInt(); //Input number

        print(1, num);
    }
}
