public class maximumProductSubArray {
    public static int maxProduct(int[] nums) {
        int pre = 1;
        int suf = 1;
        int ans = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if(pre == 0) pre = 1;
            if(suf == 0) suf = 1;

            pre = pre * nums[i];
            suf = suf * nums[n-i-1];

            ans = Math.max(ans, Math.max(pre,suf));
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] nums = {2,3,-2,4,0,1, 2, 3, 4, 0};
        System.out.println(maxProduct(nums));
    }
}
