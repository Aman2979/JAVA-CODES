public class sumOfSubArrayRanges {
    public static long subArrayRanges(int []arr){
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int smallest = arr[i];
            int largest = arr[i];
            for (int j = i; j < arr.length; j++) {
                smallest = Math.min(smallest,arr[j]);
                largest = Math.max(largest, arr[j]);
                int range = largest - smallest;
                sum = sum  +  range;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int []arr = {1,2,3};
        long ans = subArrayRanges(arr);
        System.out.println(ans);

    }
}
