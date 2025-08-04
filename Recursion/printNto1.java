import java.util.Scanner;

public class printNto1 {
    static void print(int num){
        if (num < 1){
            return;
        }

        System.out.print(num+" ");
        print(num-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter the number: ");
        int num = sc.nextInt(); //Input number
        print(num);
    }
}
