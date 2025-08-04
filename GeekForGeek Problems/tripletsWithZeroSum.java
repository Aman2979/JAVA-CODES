import java.util.*;

public class tripletsWithZeroSum {

//    // Method to find all triplets in the array that sum up to zero -->> O(n^3).
//    public List<List<Integer>> findTriplets(int[] arr) {
//        List<List<Integer>> ans = new ArrayList<>();  // List to store all valid triplets
//        int n = arr.length;  // Length of the input array
//
//        // Iterate through each element as the first element of the triplet
//        for (int i = 0; i < n; i++) {
//            // Iterate for the second element, starting from the next position
//            for (int j = i + 1; j < n; j++) {
//                // Iterate for the third element, starting from the next of second element
//                for (int k = j + 1; k < n; k++) {
//                    // Check if the sum of the three elements is zero
//                    if (arr[i] + arr[j] + arr[k] == 0) {
//                        // Create a list of the triplet and add it to the result list
//                        List<Integer> ans1 = Arrays.asList(i, j, k);
//                        ans.add(ans1);
//                    }
//                }
//            }
//        }
//        return ans;  // Return the list of triplets
//    }



    //By hashSet...
    // Method to find all triplets in the array that sum up to zero
    public List<List<Integer>> findTriplets(int[] arr){
        Set<List<Integer>> ans = new HashSet<>();  // List to store all valid triplets
        int n = arr.length;  // Length of the input array

        // Iterate through each element as the first element of the triplet
        for (int i = 0; i < n-2; i++) {
            Map<Integer, Integer> indexMap = new HashMap<>();
            // Iterate for the second element, starting from the next position
            for (int j = i + 1; j < n; j++) {
                int diff = -arr[i] - arr[j];
                    // Check if the sum of the three elements is zero
                    if (indexMap.containsKey(diff)) {
                        // Create a list of the triplet and add it to the result list
                        List<Integer> triplets = Arrays.asList(i, j, indexMap.get(diff));
                        triplets.sort(null);
                        ans.add(triplets);
                }
                indexMap.put(arr[j], j);
            }
        }
        return new ArrayList<>(ans);  // Return the list of triplets
    }

    // Main method to test the code
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};  // Example array

        // Create an instance of the class
        tripletsWithZeroSum tripletsFinder = new tripletsWithZeroSum();

        // Call the method and print the result
        List<List<Integer>> result = tripletsFinder.findTriplets(arr);
        System.out.println("Triplets with zero sum: " + result);
    }
}

