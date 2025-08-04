public class rotateMatrix {
    public static void rotate(int [][]mat){
        int n = mat.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        //reverse the every column.
        for (int j = 0; j < mat[0].length; j++) {  // Loop through each column
            for (int i = 0; i < n / 2; i++) {  // Swap from top to bottom
                int temp = mat[i][j];
                mat[i][j] = mat[n - 1 - i][j];
                mat[n - 1 - i][j] = temp;
            }
        }
    }

    public static void printMatrix(int [][]mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int [][]mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(mat);
        printMatrix(mat);
    }
}

