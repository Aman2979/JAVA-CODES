public class searchRotateWithDuplicate {
    public static boolean format(int []arr, int target){
        int low = 0, high = arr.length - 1;
        while (low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == target) return true;
            if(arr[mid] == arr[low] && arr[mid] == arr[high]){
                low = low+1;
                high = high-1;
                continue;
            }

            //left half is sorted...
            if(arr[mid] <= arr[low]){
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }

            //Right half is sorted
            else{
                if(arr[mid] <= target && target <= arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 1, 3, 3, 3};
        int target = 1;
        System.out.println("Your array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        boolean result = format(arr,target);
        System.out.println("Your result is: "+result);
    }

}
