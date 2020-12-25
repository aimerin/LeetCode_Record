package BackTrack.q51_N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(8);
    }
    List<List<String>> re = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row:board) {
            Arrays.fill(row, '.');
        }
        backTrack(board, 0);
        return re;

    }
    public void backTrack(char[][]board,int row) {
        if (row == board.length) {
            re.add(array2list(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if(!isValid(board,row,col)) continue;
            board[row][col] = 'Q';
            backTrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    public boolean isValid(char[][] board, int row,int col) {
        int n = board.length;
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public List<String> array2list(char[][] board) {
        List<String> re = new ArrayList<>();
        for (char[] row:board) {
            String temp = String.valueOf(row);
            re.add(temp);
        }
        return re;
    }
}
