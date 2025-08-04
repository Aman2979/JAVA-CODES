public class findElementInArray {
    public static int findTarget(int []arr, int target){
        int n = arr.length;
        int low = 0, high = n-1;
        while (low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == target) return mid;
            else if (target <= arr[mid]) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int []arr = {23, 45, 56, 67, 89, 92, 93, 99};
        int target = 56;
        System.out.println("Your Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int result = findTarget(arr,target);
        System.out.println("Your target is: "+result);
    }
}
