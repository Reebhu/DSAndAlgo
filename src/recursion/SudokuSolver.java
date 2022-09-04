package recursion;


import util.Util;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {
    static int N = 9;

    public static void main(String[] args) {
        int[][] input = {{5, 3, 0, 0, 7, 0, 0, 0, 0}, {6, 0, 0, 1, 9, 5, 0, 0, 0}, {0, 9, 8, 0, 0, 0, 0, 6, 0}, {8, 0, 0, 0, 6, 0, 0, 0, 3}, {4, 0, 0, 8, 0, 3, 0, 0, 1}, {7, 0, 0, 0, 2, 0, 0, 0, 6}, {0, 6, 0, 0, 0, 0, 2, 8, 0}, {0, 0, 0, 4, 1, 9, 0, 0, 5}, {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        List<Integer> list = new ArrayList<>();
        solve(input, 0, 0);
        Util.print2DArray(input);
    }

    private static boolean solve(int[][] input, int row, int col) {
        if (row == N - 1 && col == N) {
            return true;
        }
        if (col == N) {
            col = 0;
            row++;
        }
        if (input[row][col] != 0) {
            return solve(input, row, col + 1);
        }
        for (int i = 1; i <= 9; i++) {
            if (canInsert(i, input, row, col)) {
                input[row][col] = i;
                if (solve(input, row, col + 1) == true) {
                    return true;
                }
                input[row][col] = 0;
            }
        }
        return false;
    }


    private static boolean canInsert(int number, int[][] input, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (input[i][col] == number) {
                return false;
            }
            if (input[row][i] == number) {
                return false;
            }
            if (input[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == number) {
                return false;
            }
        }
        return true;
    }

}


