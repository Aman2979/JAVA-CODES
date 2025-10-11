public class basicsOfRecursion {
    static int cnt = 0;  // Class-level static variable to track count

    static void print() {
        if (cnt == 5) return;  // Base case to stop recursion
        cnt++;
        System.out.println(cnt);  // Print the current count
        print();  // Recursive call without parameters
    }


    public static void main(String[] args) {
        print();  
    }
}

