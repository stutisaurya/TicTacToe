package com.TicTacToe;

public class TicTacToeGame {

	char[][] gameBoard = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };

	public void printBoard() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(gameBoard[i][j]);
				System.out.print("|");
			}
			System.out.println();

		}

	}

}
