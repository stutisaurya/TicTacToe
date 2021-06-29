package com.TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	static char turn;
	static Scanner userinput;
	static String line = null;
	static int numInput;
	static String winner = null;

	// * Method to create empty Board Game of 9*9 *
	public static char[] createBoard() {
		char[] gameBoard = new char[10];
		for (int i = 1; i < 10; i++) {
			gameBoard[i] = ' ';
		}
		return gameBoard;
	}

	// * Method to choose player turn *
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

	// * Method to show Game Board *
	public static void showBoard(char[] board) {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
		System.out.println("/---|---|---\\");
	}

	// * Method for move to desired location *
	public static void moveToDesiredLocation(char[] board, boolean firstplayer) {
		Scanner input = new Scanner(System.in);
		if (firstplayer == true) // if get true then computer will start first
		{
			turn = 'X';
		} else // if get false then user will start first
			turn = 'O';
		while (winner == null) {
			System.out.println("Please enter a number between 1 to 9");
			if (turn == 'O')
				numInput = input.nextInt();
			else {
				Random rand = new Random();
				numInput = rand.nextInt((9 - 1) + 1) + 1;
			}
			winnerCondition(board); // method for winning conditions (1)Cornor Condition(2) center condition
			if (turn == 'O')
				numInput = blockOponentToNotWin(numInput, board); // method for blocking the opponot's win position

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

	// * Random true for computer and false for user to start the game *
	public static boolean startGame() {
		Random random = new Random();
		return random.nextBoolean();
	}

	// * check the winner between user and computer *
	public static String checkWinner(char[] board) {
		for (int a = 0; a < 8; a++) {

			switch (a) {
			case 0: {
				line = Character.toString(board[1]) + Character.toString(board[2]) + Character.toString(board[3]);
				break;
			}
			case 1: {
				line = Character.toString(board[4]) + Character.toString(board[5]) + Character.toString(board[6]);
				break;
			}
			case 2: {
				line = Character.toString(board[7]) + Character.toString(board[8]) + Character.toString(board[9]);
				break;
			}
			case 3: {
				line = Character.toString(board[1]) + Character.toString(board[4]) + Character.toString(board[7]);
				break;
			}
			case 4: {
				line = Character.toString(board[2]) + Character.toString(board[5]) + Character.toString(board[8]);
				break;
			}
			case 5: {
				line = Character.toString(board[3]) + Character.toString(board[6]) + Character.toString(board[9]);
				break;
			}
			case 6: {
				line = Character.toString(board[1]) + Character.toString(board[5]) + Character.toString(board[9]);
				break;
			}
			case 7: {
				line = Character.toString(board[3]) + Character.toString(board[5]) + Character.toString(board[7]);
				break;
			}

			}
			if (line.equals("XXX")) { // if we get 3 consecutive XXX in any diagonal and straight row then computer
										// will win
				return "Computer";
			} else if (line.equals("OOO")) {
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

		System.out.println(turn + " enter a slot number to place " + turn + " in:");
		return null;
	}

	public static void moveToComputerWin(char[] board, int numInput) {
		board[numInput] = 'X';
	}

	// * do block the position of opponont if he is goining to win *
	public static int blockOponentToNotWin(int numInput, char[] board) {
		for (int a = 0; a < 8; a++) {
			String str;
			switch (a) {
			case 0: {
				str = Character.toString(board[1]) + Character.toString(board[2]) + Character.toString(board[3]);
				if (str == "XX") {
					for (int i = 1; i <= 3; i++) {
						if (board[i] == ' ') {
							turn = 'O';
							numInput = i;
							return numInput;
						}
					}

				}
				break;
			}
			case 1: {
				str = Character.toString(board[4]) + Character.toString(board[5]) + Character.toString(board[6]);
				if (str == "XX") {
					for (int i = 1; i <= 3; i++) {
						if (board[i] == ' ') {
							turn = 'O';
							numInput = i;
							return numInput;
						}
					}

				}
				break;
			}
			case 2: {
				str = Character.toString(board[7]) + Character.toString(board[8]) + Character.toString(board[9]);
				if (str == "XX") {
					for (int i = 7; i <= 9; i++) {
						if (board[i] == ' ') {
							turn = 'O';
							numInput = i;
							return numInput;
						}
					}

				}
				break;
			}
			case 3: {
				str = Character.toString(board[1]) + Character.toString(board[4]) + Character.toString(board[7]);
				if (str == "XX") {
					for (int i = 1; i <= 7; i += 3) {
						if (board[i] == ' ') {
							turn = 'O';
							numInput = i;
							return numInput;
						}
					}

				}
				break;
			}
			case 4: {
				str = Character.toString(board[2]) + Character.toString(board[5]) + Character.toString(board[8]);
				if (str == "XX") {
					for (int i = 2; i <= 8; i += 3) {
						if (board[i] == ' ') {
							turn = 'O';
							numInput = i;
							return numInput;
						}
					}

				}
				break;
			}
			case 5: {
				str = Character.toString(board[3]) + Character.toString(board[6]) + Character.toString(board[9]);
				if (str == "XX") {
					for (int i = 3; i <= 9; i += 3) {
						if (board[i] == ' ') {
							turn = 'O';
							numInput = i;
							return numInput;
						}
					}

				}
				break;
			}
			case 6: {
				str = Character.toString(board[1]) + Character.toString(board[5]) + Character.toString(board[9]);
				if (str == "XX") {
					for (int i = 1; i <= 9; i += 4) {
						if (board[i] == ' ') {
							turn = 'O';
							numInput = i;
							return numInput;
						}
					}

				}
				break;
			}
			case 7: {
				str = Character.toString(board[3]) + Character.toString(board[5]) + Character.toString(board[7]);
				if (str == "XX") {
					for (int i = 3; i <= 7; i += 2) {
						if (board[i] == ' ') {
							turn = 'O';
							numInput = i;
							return numInput;
						}
					}

				}
				break;
			}
			}
		}
		return numInput;
	}

	// * Winner Condition for cornor cases *
	public static void winnerCondition(char[] board) {
		if (winner == null) // we will choose cornor when no one is going to winning
		{
			if (board[1] == ' ') {
				numInput = 1;
				return;
			} else if (board[3] == ' ') {
				numInput = 3;
				return;
			} else if (board[7] == ' ') {
				numInput = 7;
				return;
			} else if (board[9] == ' ') {
				numInput = 9;
				return;
			} else if (board[5] == ' ') // we will choose center when no one is going to win and there is no cornor
										// available
			{
				numInput = 5;
				return;
			}

		} else if (winner == "User") {
			moveToComputerWin(board, numInput); // if User is winning by taking any particular position than computer
												// will follow that one to win purpose
			winner = null;
		}
	}

	// Main
	public static void main(String[] args) {
		while (true) {
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

}
