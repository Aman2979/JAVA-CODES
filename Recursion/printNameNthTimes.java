import java.util.Scanner;

public class printNameNthTimes {
    static void printName(int i,int num){
        if (i > num){ //Base condition
            return;
        }
        System.out.println("Aman Raj");
        printName(i+1, num); //Function call
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the number: ");
        int num = sc.nextInt(); //Input number

        //Function call
        printName(1, num);
    }
}
