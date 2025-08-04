import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class nQueenProblemBrute {
    static boolean validate(char [][] board, int row,int col){
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0){
            if (board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0){
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length){
            if (board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }

        return true;
    }
    static List<String> construct(char[][] board){
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    static void dfs(int col, char[][] board, List<List<String>> ansList){
        if (col == board.length){
            ansList.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)){
                board[row][col] = 'Q';
                dfs(col+1,board,ansList);
                board[row][col] = '.';
            }
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ansList = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0,board,ansList);
        return ansList;
    }
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> answer = solveNQueens(n);
        System.out.println(answer);
    }
}
