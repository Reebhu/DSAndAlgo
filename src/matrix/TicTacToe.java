package matrix;

import java.util.Arrays;

public class TicTacToe {
	/*Assume the following rules are for the tic-tac-toe game on an n x n board between two players:
A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves are allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
[0, 0, 1],
[0, 2, 2],
[2, 2, 1],
[1, 1, 2],
[2, 0, 1],
[1, 0, 2],
[2, 1, 1]
Moves

[row,col,playerid]*/
	public static void main(String[] args) {

		int[][] board = new int[3][3];

		int[][] inputs = {{0, 0, 1}, {0, 2, 2}, {2, 2, 1}, {1, 1, 2}, {2, 0, 1}, {1, 0, 2}, {2, 1, 1}};

		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], 0);
		}

		for (int k = 0; k < inputs.length; k++) {
			int i = inputs[k][0];
			int j = inputs[k][1];
			int playNum = inputs[k][2];
			if (isValid(i, j, board)) {
				board[i][j] = playNum;
				if (checkHorizontal(i, playNum, board) || checkVertical(j, playNum, board) || checkDiagonal(i, j, playNum, board)) {
					System.out.println(playNum + " wins");
					break;
				}
			}
		}
	}

	static boolean isValid(int i, int j, int[][] board) {
		return board[i][j] == 0;
	}

	static boolean checkHorizontal(int i, int playerNum, int[][] board) {
		boolean win = true;
		for (int k = 0; k < 3; k++) {
			if (board[i][k] != playerNum) {
				win = false;
			}
		}
		return win;
	}

	static boolean checkVertical(int j, int playerNum, int[][] board) {
		boolean win = true;
		for (int k = 0; k < 3; k++) {
			if (board[k][j] != playerNum) {
				win = false;
			}
		}
		return win;
	}

	static boolean checkDiagonal(int i, int j, int playerNum, int[][] board) {
		if (i != j && (i != 0 || i != 2) && (j != 0 || j != 2)) {
			return false;
		}
		boolean win = true;
		for (int k = 0; k < 3; k++) {
			if (board[k][k] != playerNum) {
				win = false;
			}
		}
		if (win)
			return win;

		win = true;

		int n = board.length;

		for (int k = 0; k < 3; k++) {
			if (board[n - k - 1][k] != playerNum) {
				win = false;
			}
		}
		return win;
	}

}
