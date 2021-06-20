package com.TicTacToe;

public class Main {

	static char userSymbol, computerSymbol;

	public static void main(String[] args) {

		System.out.println("Welcome To Tic Toc Toe Game");
		TicTacToeGame ticTacGame = new TicTacToeGame();
		ticTacGame.printBoard();
		userSymbol = ticTacGame.chooseYourCharacter();
		if (userSymbol == 'X') {
			computerSymbol = 'O';
		} else if (userSymbol == 'O') {
			computerSymbol = 'X';
		}
	}

}
