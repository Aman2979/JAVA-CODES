import java.util.*;

public class kthLargest {
    public static int kthLargestElement(int []nums, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
        return priorityQueue.peek();
    }
    public static void main(String[] args) {
        int []nums = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(kthLargestElement(nums, k));
    }
}
