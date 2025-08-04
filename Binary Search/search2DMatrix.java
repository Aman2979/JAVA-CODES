public class search2DMatrix {
    public static boolean binarySearch(int []matrix, int target){
        int n = matrix.length;
        int low = 0;
        int high = n-1;
        while (low <= high){
            int mid = (low+high)/2;
            if (matrix[mid] == target) {
                return true;
            } else if(matrix[mid] < target){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return false;
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][m-1]){
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public static boolean Optimal(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = (n*m)-1;
        while (low <= high){
            int mid = (low+high)/2;
            int row = mid/m, col = mid%m;
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        int [][]matrix = {
                {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},
                {10,13,14,17,24},{18,21,23,26,30}};
        int target = 18;
        boolean answer = Optimal(matrix,target);
        System.out.println(answer);
    }
}
