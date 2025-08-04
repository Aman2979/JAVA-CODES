import java.util.Scanner;

public class byBackTrackingPrintNto1 {
    static void print(int i, int num){
        if (i>num) return;
        print(i+1, num);
        System.out.print(i+" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter the number: ");
        int num = sc.nextInt(); //Input number
        print(1, num);
    }
}
