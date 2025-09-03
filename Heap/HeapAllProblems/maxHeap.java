public class maxHeap {
    public static void heapify_up(int[] nums, int ind) {
        int parent = (ind - 1) / 2;
        if (ind > 0 && nums[ind] > nums[parent]) {
            int temp = nums[ind];
            nums[ind] = nums[parent];
            nums[parent] = temp;
            heapify_up(nums, parent); // go up
        }
    }

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

    public static void heapify(int[] nums, int ind, int val) {
        if (nums[ind] < val) {
            nums[ind] = val;
            heapify_up(nums, ind);
        } else {
            nums[ind] = val;
            heapify_dwon(nums, ind);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 7, 6, 4, 5, 4, 5, 3, 2};
        int ind = 0;
        int val = 15;
        heapify(nums, ind, val);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
