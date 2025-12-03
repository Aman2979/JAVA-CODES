public class temp {
        public static void main(String[] args) {

            int n = 9;   // total rows

            for (int i = 1; i <= n; i++) {
                // Print leading spaces
                for (int sp = 0; sp < Math.abs(5 - i) * 2; sp++) {
                    System.out.print(" ");
                }

                // Print characters
                int start;
                int end;

                if (i <= 5) {   // Upper half
                    start = 9 - (i - 1);
                    end = 1 + (i - 1);
                } else {        // Lower half
                    start = i;
                    end = 10 - i;
                }

                if (i <= 5) {
                    for (int ch = start; ch >= end; ch--) {
                        System.out.print((char)(ch + 64) + " ");
                    }
                } else {
                    for (int ch = end; ch <= start; ch++) {
                        System.out.print((char)(ch + 64) + " ");
                    }
                }

                System.out.println();
            }
        }
}
