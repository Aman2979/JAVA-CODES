import java.util.*;

public class countAllTriplets {
    public static int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;
////        Arrays.sort(arr);
//        for (int i = 0; i < n - 2; i++) {
//            int left = i + 1;
//            int right = n - 1;
//
//            while (left < right) {
//                int sum = arr[i] + arr[left] + arr[right];
//
//                if (sum == target) {
//                    count++;
//                    left++;  // Continue exploring new pairs
//                    right--;
//                } else if (sum < target) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//        return count;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    if (arr[left] == arr[right]) {
                        int pairs = (right - left + 1);
                        count += (pairs * (pairs - 1)) / 2;
                        break;
                    } else {
                        int lCount = 1;
                        int rCount = 1;

                        // Count duplicates from left
                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            lCount++;
                            left++;
                        }

                        // Count duplicates from right
                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            rCount++;
                            right--;
                        }

                        // Count all possible pairs
                        count += lCount * rCount;

                        // Move both pointers to continue search
                        left++;
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static int usingHashmap(int []arr, int target){
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int k = n - 1; k > i; k--) {
                int required = target - arr[i] - arr[k];

                // Check if a pair exists for the current required sum
                if (map.containsKey(required)) {
                    count += map.get(required);
                }

                // Add arr[k] to map for future pairs
                map.put(arr[k], map.getOrDefault(arr[k], 0) + 1);
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int []arr = {-3, -1, -1, 0, 1, 2};
        int target = -2;
        int answer = usingHashmap(arr,target);
        System.out.println(answer);
    }
}
