import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class subArrayContainingAtMosTwo {
    public static int bruteSolution(int []arr){
        //Time Complexity = O(N*N)
        //Scape Complexity = O(3)
        Set<Integer> set = new HashSet<>();
        int n = arr.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.add(arr[j]);
                if (set.size() <= 2){
                    maxLength = Math.max(maxLength, j-i+1);
                }else {
                    break;
                }
            }
        }
        return maxLength;
    }

    public static int optimalSolution(int []arr){
        //Time Complexity = O(N)
        //Scape Complexity = O(1)
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int leftPointer = 0, rightPointer = 0, maxLength = 0;

        while (rightPointer < n) {
            // Add the current element to the map
            map.put(arr[rightPointer], map.getOrDefault(arr[rightPointer], 0) + 1);

            // If more than 2 distinct elements exist, shrink the window from left
            while (map.size() > 2) {
                map.put(arr[leftPointer], map.get(arr[leftPointer]) - 1);
                if (map.get(arr[leftPointer]) == 0) {
                    map.remove(arr[leftPointer]);
                }
                leftPointer++;
            }

            // Update maxLength after adjusting the window
            maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
            rightPointer++;
        }

        return maxLength;
    }
    public static void main(String[] args) {
        int []arr = {3, 1, 2, 2, 2, 2};
        int answer = optimalSolution(arr);
        System.out.println(answer);
    }
}
