package sheet4.tictactoe;

import java.util.Scanner;

public class TicTacToe {

	private final int FIELD_SIZE = 9;

	private char[] field;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TicTacToe instance = new TicTacToe();
		boolean active = true;

		while (active) {
			instance.initField();
			instance.startGame();
			System.out.println("You want to play another round? [y/n]");
			if (sc.next().equals("n"))
				active = false;
		}
		System.out.println("Good Bye!");
	}

	private void startGame() {
		boolean gameOver = false;

		char[] player = { 'X', 'O' };

		int i = 0;
		while (!gameOver) {
			printField();
			char activePlayer = player[i++ % 2];
			System.out.print("Player " + activePlayer + " where do you want to put your mark: ");
			makeTheMark(sc.nextInt(), activePlayer);
			if (isWinner(activePlayer)) {
				System.out.println("Player " + activePlayer + " won the game!");
				gameOver = true;
			}
		}
		printField();
	}

	private boolean isWinner(char player) {
		String goal = String.valueOf(player).repeat(3); 
		boolean playerHasWon = false;
		 			
		// Check rows and columns
		for (int i = 0; i < 3; i++) {
			char[] row =  {field[i*3], field[i*3+1], field[i*3+2]};
			char[] column = {field[i], field[i+3], field[i+6]};
			if(String.valueOf(row).equals(goal) || String.valueOf(column).equals(goal)) 
				playerHasWon = true; 
		}
		
		// Checkt diagonal
		char[] diagonalOne = {field[0], field[4], field[8]};  
		char[] diagonalTwo = {field[2], field[4], field[6]};  
		if(String.valueOf(diagonalOne).equals(goal)|| String.valueOf(diagonalTwo).equals(goal))
			playerHasWon = true; 

		return playerHasWon;
	}

	private void makeTheMark(int pos, char mark) {
		for (int i = 0; i < field.length; i++) {
			if (field[i] == (char) pos + 48) {
				field[i] = mark;
			}
		}
	}

	private void initField() {
		field = new char[FIELD_SIZE];
		for (int i = 0; i < field.length; i++) {
			field[i] = (char) (i + 49);
		}
	}

	public void printField() {
		for (int i = 0; i < field.length; i++) {
			System.out.print(field[i] + "\t");
			if (i % Math.sqrt(FIELD_SIZE) == 2)
				System.out.println('\n');
		}
	}

}
