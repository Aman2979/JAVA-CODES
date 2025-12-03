public class floodFillAlgo {
    public static int[][] dfs(int [][]ans, int [][]image, int row, int col, int []delRow, int []delCol, int iniColor, int newColor){
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
            image[nRow][nCol] == iniColor && ans[nRow][nCol] != newColor){
                dfs(ans, image, nRow,nCol, delRow, delCol, iniColor, newColor);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [][]image = {{1, 1, 1}, {2, 2, 0}, {2, 2, 2}};
        int sr = 2, sc = 0, color = 3;
        int [][]ans = image;
        int iniColor = image[sr][sc];
        int []delRow = {-1, 0, +1, 0};
        int []delCol = {0, +1, 0, -1};
        int [][]Answer = dfs(ans, image, sr, sc, delRow, delCol, iniColor, color);
        for (int i = 0; i < Answer.length; i++) {
            for (int j = 0; j < Answer[0].length; j++) {
                System.out.print(Answer[i][j]+" ");
            }
            System.out.println();
        }
    }
}
