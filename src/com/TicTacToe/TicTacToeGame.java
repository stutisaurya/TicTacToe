package com.TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	static char turn;
	static Scanner userinput;

	// * UC1 * //
	public static char[] createBoard() {
		char[] gameBoard = new char[10];
		for (int i = 1; i < 10; i++) {
			gameBoard[i] = ' ';
		}
		return gameBoard;
	}

	// * UC2 * //
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

	// * UC3 * //
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
	public static void moveToDesiredLocation(char[] board, boolean firstplayer) {
		Scanner input = new Scanner(System.in);
		String winner = null;
		int numInput;
		// int j=0;
		if (firstplayer == true) // if get true then computer will start first
		{
			turn = 'X';
		} else // if get false then user will start first
			turn = 'O';
		while (winner == null) {
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
				winner = checkWinner(board); // we will check the winner through this method
			} else {
				System.out.println("Slot already taken; re-enter slot number:");
				showBoard(board);
				continue;
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
	}

	// * UC6 *
	public static boolean startGame() {
		Random random = new Random();
		return random.nextBoolean();
	}

	// * UC7 *
	public static String checkWinner(char[] board) {
		for (int a = 0; a < 8; a++) {
			StringBuilder sb = new StringBuilder();
			String line;
			switch (a) {
			case 0:
				line = Character.toString(board[1]) + Character.toString(board[2]) + Character.toString(board[3]);
				break;
			case 1:
				line = Character.toString(board[4]) + Character.toString(board[5]) + Character.toString(board[6]);
				break;
			case 2:
				line = Character.toString(board[7]) + Character.toString(board[8]) + Character.toString(board[9]);
				break;
			case 3:
				line = Character.toString(board[1]) + Character.toString(board[4]) + Character.toString(board[7]);
				break;
			case 4:
				line = Character.toString(board[2]) + Character.toString(board[5]) + Character.toString(board[8]);
				break;
			case 5:
				line = Character.toString(board[3]) + Character.toString(board[6]) + Character.toString(board[9]);
				break;
			case 6:
				line = Character.toString(board[1]) + Character.toString(board[5]) + Character.toString(board[9]);
				break;
			case 7: {
				line = Character.toString(board[3]) + Character.toString(board[5]) + Character.toString(board[7]);
				System.out.println("String is: " + line);
				break;
			}
			}
			if (sb.equals("XXX")) { // if we get 3 consecutive XXX in any diagonal and straight row then computer
									// will win
				return "Computer";
			} else if (sb.equals("OOO")) {
				return "User"; // if we get 3 consecutive OOO in any diagonal and straight row then user will
								// win
			}
		}
		for (int a = 0; a < 9; a++) {
			if (board[a] == ' ') {
				break;
			} else if (a == 8)
				return "draw"; // if we not get any 3 consecutive XXX and OOO in any diagonal and straight row
								// then the game is draw
		}

		System.out.println(turn + " turn; enter a slot number to place " + turn + " in:");
		return null;
	}

	public static void main(String[] args) {
		Scanner userinput = new Scanner(System.in);
		char[] board = createBoard(); // Method for creating Empty board for game
		System.out.println("Welocme to User And Computer Player");
		char turn = choosePlayerTurn(); // Method for choose player turn
		showBoard(board); // Method to show board of Tic Tac Toe Toe toe game
		Boolean firstplayer = startGame(); // Method to get randomly which one will start first
		System.out.println("We get randomly this " + firstplayer);
		moveToDesiredLocation(board, firstplayer); // Method to go desired location to user in game

	}
}
