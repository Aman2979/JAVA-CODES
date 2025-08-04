public class reverseString {
    //Method 1.
    public static void format1(String fun){
        int n = fun.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            ans = fun.charAt(i) + ans;
        }
        System.out.println(ans);
    }
    //Method 2.
    public static void format2(String fun){
        char [] arr = fun.toCharArray();
        int l = 0;
        int r = arr.length-1;
        while (l<r){
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        format2("Aman");
    }
}
