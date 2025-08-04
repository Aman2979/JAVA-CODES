public class printAllSubString {
    public static void format(String name){
        int n = name.length();
        for (int startIndex = 0; startIndex < n; startIndex++) {
            for (int endIndex = startIndex+1; endIndex <=n ; endIndex++) {
                System.out.println(name.substring(startIndex,endIndex));
            }
        }
    }
    public static void main(String[] args) {
        String name = "ABC";
        format(name);
    }
}
