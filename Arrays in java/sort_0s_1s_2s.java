public class sort_0s_1s_2s {
    public static void format(int []arr){
        int n = arr.length;
        int low = 0, mid = 0, high = n-1;
        while (mid <= high){
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int []arr = {0, 1, 2, 0, 2, 1, 1, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
            format(arr);
    }
    
}
