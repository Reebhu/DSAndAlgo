package recursion;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        printnQueens(7);
    }

    public static void printnQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> res = new ArrayList<List<String>>();
        Arrays.stream(board).forEach(a -> Arrays.fill(a, '-'));
        chessBoard(0, board, res);
        for (List<String> i : res) {
            for (String j : i) {
                System.out.println(j + " ");
            }
            System.out.println();
        }
    }

    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


    public static void chessBoard1(int col, char[][] board, List<List<String>> ans) {
        if (col == board.length) {
            ans.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (checkConflict(board, i, col)) {
                board[i][col] = 'Q';
                chessBoard(col + 1, board, ans);
                board[i][col] = '-';
            }
        }
    }


    public static void chessBoard(int col, char[][] board, List<List<String>> ans) {
        if (col == board.length) {
            Util.print2DArray(board);
            System.out.println();
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (!checkConflict(board, i, col)) {
                board[i][col] = 'Q';
                chessBoard(col + 1, board, ans);
                board[i][col] = '-';
            }
        }
    }

    private static boolean checkConflict(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return true;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return true;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return true;
            col--;
            row++;
        }
        return false;
    }
}
