public class LemonadeChange {
    private static boolean checkValid(int[] bills) {
        int cnt5 = 0;  // Count of $5 bills
        int cnt10 = 0; // Count of $10 bills

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                // Customer pays with $5, no change needed
                cnt5++;
            } else if (bills[i] == 10) {
                // Customer pays with $10, needs $5 as change
                if (cnt5 > 0) {
                    cnt5--; // Give back one $5 bill as change
                    cnt10++; // Store one $10 bill
                } else {
                    return false; // No $5 bill available for change
                }
            } else { // bills[i] == 20
                // Customer pays with $20, needs $15 as change
                if (cnt5 > 0 && cnt10 > 0) {
                    // Prefer giving one $10 bill and one $5 bill as change
                    cnt10--;
                    cnt5--;
                } else if (cnt5 >= 3) {
                    // If no $10 bill, give three $5 bills as change
                    cnt5 -= 3;
                } else {
                    return false; // Not enough change available
                }
            }
        }
        return true; // Successfully provided change for all customers
    }
    public static void main(String[] args) {
        int []bills = {5, 5, 10, 10, 20};
        boolean ans = checkValid(bills);
        System.out.println(ans);
    }
}
