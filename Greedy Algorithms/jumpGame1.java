public class jumpGame1 {
    public static boolean checkValidOrNot(int []nums){
        int n = nums.length;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxIndex) return false;
            maxIndex = Math.max(maxIndex, i+nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        int []nums = {2,3,1,1,1, 0,4};
        boolean answer = checkValidOrNot(nums);
        System.out.println(answer);
    }
}
