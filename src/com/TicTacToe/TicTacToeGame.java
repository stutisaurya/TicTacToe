package com.TicTacToe;

import java.util.Scanner;

public class TicTacToeGame {
	static String turn;

	public static char[] createBoard() {
		char[] gameBoard = new char[10];
		for (int i = 1; i < 10; i++) {
			gameBoard[i] = ' ';
		}
		return gameBoard;
	}

	public static String choosePlayerTurn() {
		System.out.println("Write the play key");
		Scanner sc = new Scanner(System.in);
		turn = sc.nextLine(); // X is for computer player and O for User player
		if (turn.equals("X")) {
			System.out.println("Computer is playing");
			turn = "O"; // Computer is playing so now it is turn to play user
			return turn;
		} else {
			System.out.println("User is playing");
			turn = "X"; // User is playing so now it is turn to play computer
			return turn;
		}
	}

	public static void showBoard(char[] board) {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
		System.out.println("/---|---|---\\");
	}

	public static void main(String[] args) {
		char[] board = createBoard(); // Method for creating Empty board for game
		System.out.println("Welocme to User And Computer Player");
		String turn = choosePlayerTurn(); // Method for choose player turn
		showBoard(board);
	}
}
