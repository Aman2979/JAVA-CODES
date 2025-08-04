public class reverseArray {
    static void print1(int []arr){
        print(arr, 0, arr.length-1);
    }
    static void print(int []arr, int left, int right){
        if (left >= right) return;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        print(arr,left+1,right-1);
    }
    public static void main(String[] args) {
        int []arr = {1, 2, 3, 3, 5};

        print1(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
