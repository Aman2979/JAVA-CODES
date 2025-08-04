import java.util.*;

public class removeDuplicates {

    // Brute Force Solution (Using HashSet)
    static ArrayList<Integer> removeDuplicateInArray(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        Set<Integer> temp = new HashSet<>();  // HashSet to store unique elements
        int n = arr.length;

        // Loop through the array and add elements to HashSet (duplicates are automatically ignored)
        for (int i = 0; i < n; i++) {
            temp.add(arr[i]);
        }

        // Add all unique elements from HashSet to ArrayList (result)
        for(int val : temp) {
            ans.add(val);
        }

        return ans;  // Return the ArrayList with unique elements
    }

    // Optimal Solution (Preserves Insertion Order)
    static ArrayList<Integer> removeDuplicate(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();  // ArrayList to store unique elements
        int n = arr.length;

        // Loop through the array and check if the element is already in the result list
        for (int i = 0; i < n; i++) {
            if (!ans.contains(arr[i])) {  // If the element is not already in ans, add it
                ans.add(arr[i]);
            }
        }

        return ans;  // Return the ArrayList with unique elements (in original order)
    }

    public static void main(String[] args) {
        int []arr = {2, 7, 5, 10, 4, 7, 2, 8, 8, 6, 3, 8, 3, 6};  // Sample input array

        // Call the optimal solution to remove duplicates while maintaining order
        ArrayList<Integer> ans = removeDuplicate(arr);

        // Print the resulting list of unique elements
        System.out.println(ans);  // Output: [2, 7, 5, 10, 4, 8, 6, 3]
    }
}

