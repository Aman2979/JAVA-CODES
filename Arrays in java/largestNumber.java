public class largestNumber {
    public static String largestNum(int[] nums) {
        int n = nums.length;
        String ans = "";
        for (int i = 0; i < n; i++) {
            ans = (String)(nums[i] + ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] nums = {10, 2};
        String answer = largestNum(nums);
        System.out.println(answer);
    }
}
