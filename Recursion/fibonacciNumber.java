import java.util.Scanner;

public class fibonacciNumber {
    private static void printFibonacciNumber(int n){
        if (n == 0){
            System.out.println(0);
        }else {
            int []fib = new int[n+1];
            fib[0] = 0;
            fib[1] = 1;
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i-1] + fib[i-2];
            }

            for (int i = 0; i < n; i++) {
                System.out.print(fib[i]+" ");
            }
        }
    }
public static void printFibonacciNum(int n) {
    if (n == 0) {
        System.out.println("The Fibonacci Series up to " + n + "th term:");
        System.out.print(0);
    } else {
        int secondLast = 0;
        int last = 1;
        System.out.println("The Fibonacci Series up to " + n + "th term:");
        System.out.print(secondLast + " " + last + " ");
        int cur;
        for (int i = 2; i <= n; i++) {
            cur = last + secondLast;
            secondLast = last;
            last = cur;
            System.out.print(cur + " ");
        }
    }
}

// Using recursion.
    private static int printFibonacciNumber1(int n){
        if (n <= 1){
            return n;
        }
        return printFibonacciNumber1(n-1)+printFibonacciNumber1(n-2);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter your number: ");
        int n = sc.nextInt(); //Input number

        printFibonacciNum(n);
    }
}
