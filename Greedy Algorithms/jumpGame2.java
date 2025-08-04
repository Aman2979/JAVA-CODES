public class jumpGame2 {
    public static int helperFun(int index, int ans, int[] nums) {
        // Tc = O(N^N), Sc = O(N)
        int n = nums.length;
        if (index >= n-1) return ans;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
                min = Math.min(min, helperFun(index + i, ans + 1, nums));
        }
        return min;
    }
    public static int jump(int[] nums) {
        return helperFun(0 , 0, nums);
    }

    public static int optimal(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int jumps = 0;
        while (r < n-1){
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
                l = r+1;
                r = farthest;
                jumps++;
        }
        return jumps;
    }
    public static void main(String[] args) {
        int []nums = {2, 3, 1, 1, 4, 0, 0, 0, 1, 2};
        int ans = optimal(nums);
        System.out.println(ans);
    }
}
