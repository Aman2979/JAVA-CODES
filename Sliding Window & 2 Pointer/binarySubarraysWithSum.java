public class binarySubarraysWithSum {
    public static int possibleSubArray(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private static int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;

        int cnt = 0, sum = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            cnt += right - left + 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int []nums = {1,0,1,0,1};
        int goal = 2;
        int ans = possibleSubArray(nums, goal);
        System.out.println(ans);
    }
}
