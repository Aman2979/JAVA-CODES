public class searchRotateArray {
    public static int rotateArray(int []arr, int target){
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                return mid;
            }

            //if left half is sorted...
            if(arr[low] <= arr[mid]){
            if(arr[low] <= target && target <= arr[mid]) {
                high = mid - 1;
            }else {
                low = mid +1;
            }

            //right half is sorted...
            } else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int []arr = {7,8,9,1,2,3,4,5,6};
        int target = 7;
        System.out.println("Before array...");
        for (int i = 0; i < arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int result = rotateArray(arr, target);
        System.out.println("The index is: "+result);
    }
}
