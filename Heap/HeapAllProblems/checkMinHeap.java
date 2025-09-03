public class checkMinHeap {
    public static boolean isMinHeap(int []nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 1;
            if (left >= n || right >= n) break;
            if (nums[i] > nums[left] || nums[i] > nums[right]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int []arr = {10, 20, 30, 21, 23};
        System.out.println(isMinHeap(arr));
    }
}
