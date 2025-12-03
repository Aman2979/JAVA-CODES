import java.util.LinkedList;
import java.util.Queue;

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
        Queue<Pair> queue = new LinkedList<>();
        int [][]visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2){
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1) freshOrange++;
            }
        }

        int tm = 0;
        int []drow = {-1, 0, +1, 0};
        int []dcol = {0, 1, 0, -1};
        int cnt = 0;

        while (!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().tm;
            tm = Math.max(tm, t);
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    queue.add(new Pair(nrow, ncol, t + 1));
                    visited[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if (cnt != freshOrange) return -1;
        return tm;
    }
    public static void main(String[] args) {
        int [][]grid = {{2,1,1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }
}
