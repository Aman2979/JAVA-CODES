import java.util.ArrayDeque;
import java.util.Deque;

public class slidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || k == 0) return new int[0];

        int[] nums = new int[n - k + 1]; // Result array for maximums
        Deque<Integer> deque = new ArrayDeque<>(); // Store indices of array elements

        for (int i = 0; i < n; i++) {
            // Remove indices out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of smaller elements in the current window
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.offerLast(i);

            // Store the maximum for the current window
            if (i >= k - 1) { // Start storing results after the first window
                nums[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(arr, k);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

