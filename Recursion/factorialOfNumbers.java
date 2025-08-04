import java.util.Scanner;

public class factorialOfNumbers {
    static int print(int num){
        if (num == 0) return 1;
        return num * print(num-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter the number: ");
        int num = sc.nextInt(); //Input number

        int ans = print(num);
        System.out.println(ans);

    }
}
