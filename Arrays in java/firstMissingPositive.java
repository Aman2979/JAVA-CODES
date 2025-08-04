public class firstMissingPositive {
    public static int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        int sumOfLength = n*(n+1)/2;
        int sumOfArray = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == -nums[i]) {
                i++;
            }else {
                sumOfArray += nums[i];
            }
        }
        result = sumOfLength - sumOfArray;
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {3,4,-1,1};
        int res = firstMissingPositive1(nums);
        System.out.println(res);

    }
}
