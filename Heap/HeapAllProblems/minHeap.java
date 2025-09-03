public class minHeap {
    public static void heapify_up(int[] nums, int ind) {
        int parent = (ind - 1) / 2;
        if (ind > 0 && nums[ind] < nums[parent]) { // smaller value moves up
            int temp = nums[ind];
            nums[ind] = nums[parent];
            nums[parent] = temp;
            heapify_up(nums, parent); // continue upward
        }
    }

    public static void heapify_down(int[] nums, int ind) {
        int smallest = ind;
        int leftChild = 2 * ind + 1;
        int rightChild = 2 * ind + 2;

        if (leftChild < nums.length && nums[leftChild] < nums[smallest]) {
            smallest = leftChild;
        }
        if (rightChild < nums.length && nums[rightChild] < nums[smallest]) {
            smallest = rightChild;
        }

        if (smallest != ind) {
            int temp = nums[ind];
            nums[ind] = nums[smallest];
            nums[smallest] = temp;
            heapify_down(nums, smallest); // continue downward
        }
    }

    public static void heapify(int[] nums, int ind, int val) {
        if (nums[ind] > val) { // if new value is smaller → move up
            nums[ind] = val;
            heapify_up(nums, ind);
        } else { // if new value is bigger → move down
            nums[ind] = val;
            heapify_down(nums, ind);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 7, 6, 5, 8, 9, 10};
        int ind = 0;
        int val = 1;  // inserting smaller value at index 0
        heapify(nums, ind, val);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
