public class Basics {
    public static void format(String s){

        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                System.out.println(s.substring(i,j));
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println();
//        }
    }
    public static void main(String[] args) {
//        String name1 = "Aman";
//        String name2 = "Kumar";
//        String name3 = name1+name2;
//        System.out.println("The Result is: "+name3);
//        System.out.println(name1.toLowerCase());
//        System.out.println(name2.toUpperCase());
//        System.out.println(name1.charAt(2));
//        System.out.println(name1.replace("a","M"));
//        System.out.println(name1);
//
//        for (int i = 0; i < name3.length(); i++) {
//            System.out.print(name3.charAt(i)+" ");
//        }

        System.out.println(" " + 9 + 10);
        System.out.println(9 + 10+" ");
        System.out.println(" " + (9 + 10));
       // format("Aman");
    }
}
