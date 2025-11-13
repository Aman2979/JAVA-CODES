class Pair{
    int row;
    int col;
    int tm;
    Pair(int row, int col, int tm){
        this.row = row;
        this.col = col;
        this.tm =  tm;
    }
}
public class rottenOranges {
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshOrange = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2 && grid[i][j] == 1){

                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int [][]grid = {{2, 0, 0}, {1, 2, 0}, {2, 1, 0}};
    }
}
