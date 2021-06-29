package com.TicTacToe;

import java.util.Scanner;

public class TicTacToeGame {
	static char turn;
	static Scanner userinput;

	// * UC1 *
	public static char[] createBoard() {
		char[] gameBoard = new char[10];
		for (int i = 1; i < 10; i++) {
			gameBoard[i] = ' ';
		}
		return gameBoard;
	}

	// * UC2 *
	public static char choosePlayerTurn() {
		System.out.println("Write the play key");
		Scanner userinput = new Scanner(System.in);
		turn = userinput.next().toUpperCase().charAt(0); // X is for computer player and O for User player
		if (turn == 'X') {
			System.out.println("Computer is playing");
			turn = 'O'; // Computer is playing so now it is turn to play user
			return turn;
		} else {
			System.out.println("User is playing");
			turn = 'X'; // User is playing so now it is turn to play computer
			return turn;
		}
	}

	// * UC3 *
	public static void showBoard(char[] board) {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
		System.out.println("/---|---|---\\");
	}

	// * UC4 *
	public static void moveToDesiredLocation(char[] board) {
		Scanner input = new Scanner(System.in);
		int numInput;
		// int j=0;
		while (true) {
			System.out.println("Please enter a number between 1 to 9");
			numInput = input.nextInt();
			if (!(numInput > 0 && numInput <= 9)) // check the input is between 1 to 9 or not
			{
				System.out.println("Invalid input; re-enter slot number:");
				continue;

			} else if (board[numInput] == ' ') {
				board[numInput] = turn;
				showBoard(board);
				if (turn == 'X') {
					turn = 'O';
				} else {
					turn = 'X';
				}
			} else {
				System.out.println("Slot already taken; re-enter slot number:");
				showBoard(board);
				continue;
			}
		}
	}

	public static void main(String[] args) {
		Scanner userinput = new Scanner(System.in);
		char[] board = createBoard(); // Method for creating Empty board for game
		System.out.println("Welocme to User And Computer Player");
		char turn = choosePlayerTurn(); // Method for choose player turn
		showBoard(board); // Method to show board of Tic Tac Toe Toe toe game
		moveToDesiredLocation(board); // Method to go desired location to user in game
	}
}
