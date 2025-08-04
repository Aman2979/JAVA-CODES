import java.util.*;
public class Basics1 {
    public static void main(String[] args) {
//        String email1 = "Aman8@gmail.com";
//        String email2 = "randomAvenger@hotmail.com";
//
//        String emailArr[] = email1.split("@");
//        String lastPart = emailArr[emailArr.length-1];
//        int dotIndex = lastPart.lastIndexOf(".");
//        System.out.println(lastPart.substring(0,dotIndex));

        StringBuilder name1 = new StringBuilder("Aman");
        StringBuilder name2 = new StringBuilder("Aman");
        StringBuilder name3 = new StringBuilder("Aman");
        StringBuilder name4 = name1;

        System.out.println(name1.equals(name2));
        System.out.println(name2.equals(name3));
        System.out.println(name3.equals(name4));
        System.out.println(name1.equals(name4));


    }
}
