public class arrayToMaxHeap {
    public static void heapify_dwon(int[] nums, int ind) {
        int largest = ind;
        int leftChild = 2 * ind + 1;
        int rightChild = 2 * ind + 2;

        if (leftChild < nums.length && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }
        if (rightChild < nums.length && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }
        if (largest != ind) {
            int temp = nums[ind];
            nums[ind] = nums[largest];
            nums[largest] = temp;
            heapify_dwon(nums, largest); // go down
        }
    }
    public static void buildHeapFromAGivenArray(int []nums){
        int n = nums.length;
        for (int ind = n-1; ind >= 0; ind--) {
            heapify_dwon(nums, ind);
        }
    }
    public static void main(String[] args) {
        int []nums = {0, 7, 6, 15, 10, 11, 1, 3};
        buildHeapFromAGivenArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
