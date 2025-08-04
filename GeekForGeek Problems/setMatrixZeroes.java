public class setMatrixZeroes {
    //Brute Solution
//    public static void marksInRow(int i, int [][]mat){
//        int n = mat.length;
//        int m = mat[0].length;
//        for (int j = 0; j < m; j++) {
//            if (mat[i][j] != 0){
//                mat[i][j] = -1;
//            }
//        }
//    }
//
//    public static void marksInCol(int j, int [][]mat){
//        int n = mat.length;
//        for (int i = 0; i < n; i++) {
//            if (mat[i][j] != 0){
//                mat[i][j] = -1;
//            }
//        }
//    }
//    public static void setMatrixZero(int [][]mat){
//        int n = mat.length;
//        int m = mat[0].length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (mat[i][j] == 0){
//                    marksInRow(i, mat);
//                    marksInCol(j, mat);
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (mat[i][j] == -1){
//                    mat[i][j] = 0;
//                }
//            }
//        }
//    }
//
//
//
//

    //Better Solution
//    public static void setMatrixZero(int [][]mat) {
//        int n = mat.length;
//        int m = mat[0].length;
//        int []row = new int[n];
//        int []col = new int[m];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (mat[i][j] == 0){
//                    row[i] = 1;
//                    col[j] = 1;
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (row[i] == 1 || col[j] == 1){
//                    mat[i][j] = 0;
//                }
//            }
//        }
//
//    }


    //Most optimal Solution
    public static void setMatrixZero(int [][]mat) {
        int n = mat.length;
        int m = mat[0].length;
        int col0 = 1; // Tracks if the first column needs to be zeroed

//        int []row = new int[n]; -->> mat[0][..]
//        int []col = new int[m]; -->> mat[..][0]

        // Mark rows and columns to be zeroed using first row and first column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0; // Mark the first cell of the row
                    if (j != 0) {
                        mat[0][j] = 0; // Mark the first cell of the column
                    } else {
                        col0 = 0; // If zero is in the first column, track it
                    }
                }
            }
        }

        // Zero the matrix except the first row and first column
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[0][j] == 0 || mat[i][0] == 0) { // Check markers
                    mat[i][j] = 0; // Zero out cells if row or column is marked
                }
            }
        }

        // Zero the first row if needed
        if (mat[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }

        // Zero the first column if needed
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }


    public static void main(String[] args) {
        int [][]mat = {{-5, 2, 3, 0}, {-2, -5, -2, -5}, {-1, 4, 4, -2}, {2, 5, 1, 4}};
        setMatrixZero(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
