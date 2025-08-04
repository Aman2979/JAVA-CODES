import java.util.ArrayList;

public class leaderElements {

    // This method finds and returns the leader elements in the array.
    // A leader element is greater than all the elements to its right.
    public static ArrayList<Integer> format(int []arr, int n) {
        // Create an ArrayList to store leader elements
        ArrayList<Integer> ans = new ArrayList<>();

        // Initialize 'maxi' to the last element of the array, as it is always a leader
        int maxi = arr[n-1];

        // Add the last element to the answer list, as it is the first leader (no elements to its right)
        ans.add(arr[n-1]);

        // Traverse the array from the second-last element to the first
        for (int i = n-2; i >= 0; i--) {
            // If the current element is greater than 'maxi', it is a leader
            if (arr[i] > maxi) {
                ans.add(arr[i]);  // Add the leader to the answer list
                maxi = arr[i];    // Update 'maxi' to the current element
            }
        }

        // Return the list of leader elements
        return ans;
    }

    public static void main(String[] args) {
        // Example input array
        int [] arr = {10, 22, 11, 12, 3, 1, 6};
        int n = arr.length;  // Get the length of the array

        // Print the original array
        System.out.println("Your array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Call the format method to find leader elements
        ArrayList<Integer> ans = format(arr, n);

        // Print the leader elements
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

