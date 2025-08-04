public class countNumberOfNiceSubarrays {
    public static int numberOfSubArrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        if (k < 0) return 0;

        int cnt = 0, sum = 0, left = 0, right = 0;

        while (right < nums.length){
            sum += (nums[right] % 2);

            while (sum > k) {
                sum -= (nums[left] % 2);
                left++;
            }
            cnt += (right - left + 1);
            right++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int []nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        int ans = numberOfSubArrays(nums, k);
        System.out.println(ans);
    }
}
