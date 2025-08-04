public class equilibriumPoint {
    private static int findPoint(int []arr){
        int rightSum = 0;
        for (int i = 0; i < arr.length; i++) {
            rightSum += arr[i];
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i]; // Update rightSum for the current element
            if (leftSum == rightSum) {
                return i; // Return the index where equilibrium is found
            }
            leftSum += arr[i]; // Update leftSum for the current element
        }
        return -1; // No equilibrium point found
    }
    public static void main(String[] args) {
        int []arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(findPoint(arr));
    }
}
