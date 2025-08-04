public class onePlaceRotate {
    public void rotate(int [] arr, int n){
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[ i - 1] = arr[i];
        }
        arr[n - 1] = temp;
    }
    public void print(int []arr, int n){
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        onePlaceRotate ob = new onePlaceRotate();
        int n = arr.length;
        ob.rotate(arr, n);
        ob.print(arr, n);

    }
    
}
