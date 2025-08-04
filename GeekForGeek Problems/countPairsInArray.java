import java.util.HashMap;
import java.util.HashSet;

public class countPairsInArray {

    // Brute force solution - O(n^2) time complexity
    static int cntPairs(int []arr, int target){
        HashSet<Integer> temp = new HashSet<>();
        int cnt = 0;
        int n = arr.length;

        // Nested loop to check all pairs (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                // If sum of arr[i] and arr[j] equals target, increment count
                if (arr[i] + arr[j] == target) {
                    cnt++;
                }
            }
        }
        return cnt;  // Return total count of pairs
    }

    // Optimal solution using HashMap - O(n) time complexity
    static int countPairs(int arr[], int target) {
        HashMap<Integer, Integer> temp = new HashMap<>();  // HashMap to store frequencies
        int cnt = 0;
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            int diff = target - arr[i];  // Calculate the difference needed for the pair

            // If the difference exists in the map, add its frequency to count
            if(temp.containsKey(diff)) {
                cnt += temp.get(diff);
            }

            // Update the frequency of arr[i] in the map
            temp.put(arr[i], temp.getOrDefault(arr[i], 0) + 1);
        }
        return cnt;  // Return total count of pairs
    }

    public static void main(String[] args) {
        int []arr = {1, 1, 1, 1};  // Input array
        int target = 2;            // Target sum to find pairs

        int ans = countPairs(arr, target);  // Call the optimal solution
        System.out.println(ans);  // Print the result (count of pairs)
    }
}

