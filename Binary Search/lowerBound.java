public class lowerBound {
    public static int lb(int []arr, int target){
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = 0;
        while (low <= high) { //Maintain the pointers...
            int mid = (low + high) / 2; //find mid_point (int form)...
            if (arr[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;

            }
        }
            return ans;
        }
    public static void main(String[] args) {
        int []arr = {1, 2, 4, 4, 5, 6, 7, 8};
        int target = 5;
        System.out.println("Your array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int result = lb(arr,target);
        System.out.println("Your lower Bound element index is: "+result);

    }
}
