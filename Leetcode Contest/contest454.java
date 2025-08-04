public class contest454 {
    static class contest454Problem1 { // Made it static
        public static String solve(String caption) {
            StringBuilder ans = new StringBuilder("#");

            boolean capitalizeNext = true;
            for (int i = 0; i < caption.length(); i++) {
                char c = caption.charAt(i);
                if (c == ' ') {
                    capitalizeNext = true;
                } else {
                    if (capitalizeNext) {
                        if (ans.length() < 2) {
                            ans.append(Character.toLowerCase(c));
                        } else {
                            ans.append(Character.toUpperCase(c));
                        }
                        capitalizeNext = false;
                    } else {
                        ans.append(c);
                    }
                }
                if (ans.length() == 100) break; // Optional cap
            }

            return ans.toString();
        }
    }

    public static void main(String[] args) {
        String caption = "Leetcode daily streak achieved";
        System.out.println(contest454Problem1.solve(caption));
    }
}
