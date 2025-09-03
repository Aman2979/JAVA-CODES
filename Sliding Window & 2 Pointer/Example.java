public class Example {
    public static int helper(int []nums){
        int largest = Integer.MIN_VALUE;
        int secondLargest = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > largest){
                secondLargest = largest;
                largest = nums[i];
            }else if (nums[i] > secondLargest && secondLargest < largest){
                secondLargest = nums[i];
            }
        }
        return secondLargest;
    }
    public static void main(String[] args) {
        int []nums = {2, 4, 5, 6, 8, 2, 9, -1, 10};
        System.out.println(helper(nums));
    }
}

