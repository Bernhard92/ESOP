
package sheet4;

import java.util.Scanner;

/**
 * 
 * @author bejahrer
 *
 */

public class Sheet4 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Aufgabe 1
		System.out.println(capitalize("Heute muss Donnerstag sein. Mit Donnerstagen kam ich noch nie zu Rande."));

		// Aufgabe 2
//		startHangman(3);

		// Aufgabe 3
		iterativeMethod(5);
		recursiveMethod(1, 5);

		// Aufgabe 4
		System.out.println(iterativeFaculty(5));
		System.out.println(recursiveFaculty(5));

		// Aufgabe 5
		/*
		 * for (int i = 1; i < Integer.MAX_VALUE; i++) { System.out.println("Testing: "
		 * + i); recursiveFaculty(i); }
		 */

		// Aufgabe 6
		System.out.println(iterativeFibonacci(10));
		System.out.println(recursiveFibonacci(10));

		// Aufgabe 7
//		System.out.println(stringToIntA("hhh"));
//		System.out.println(stringToIntB("hhh"));
//		System.out.println(stringToIntC("hhh"));

		// Aufgabe 8
		divide();

		// Aufgabe 9

		// Aufgabe 10

		// Aufgabe 11

		// Aufgabe 12

		// Aufgabe 13

		// Aufgabe 14

		// Aufgabe 15

		// Aufgabe 16

	}

	/*
	 * Aufgabe 1
	 */
	private static String capitalize(String text) {
		String[] words = text.split(" ");

		String answer = "";
		for (String word : words) {
			answer += String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1) + " ";
		}

		return answer;
	}

	/*
	 * Aufgabe 2
	 */
	private static void startHangman(int lives) {
		boolean solutionFound = false;

		System.out.println("Player 1 insert secret word!");

		String targetWord = sc.next();
		char[] targetChars = targetWord.toCharArray();

		String solution = targetChars[0] + "_".repeat(targetWord.length() - 1);

		while (lives > 0) {
			System.out.println(
					"Solution: " + solution + "\nReamaining lives: " + lives + "\nPlayer 2 insert a character");
			char newChar = sc.next().charAt(0);

			if (targetWord.contains(String.valueOf(newChar))) {
				char[] solutionChars = solution.toCharArray();
				for (int i = 0; i < targetChars.length; i++) {
					if (targetChars[i] == newChar) {
						solutionChars[i] = newChar;
					}
				}
				solution = String.valueOf(solutionChars);

				if (!solution.contains("_")) {
					solutionFound = true;
					lives = 0;
				}
			} else {
				lives--;
			}
		}
		System.out.println("Player " + (solutionFound ? "2" : "1") + " won");
	}

	/*
	 * Aufgabe 3
	 */
	private static void iterativeMethod(int n) {
		int i = 0;
		while (i < n) {
			i++;
			System.out.println(i);
		}
	}

	private static void recursiveMethod(int i, int n) {
		if (i <= n) {
			System.out.println(i);
			recursiveMethod(i + 1, n);
		}
	}

	/*
	 * Aufgabe 5
	 */
	private static int iterativeFaculty(int n) {
		int fac = 1;

		while (n >= 1) {
			fac *= n;
			n--;
		}
		return fac;
	}

	private static int recursiveFaculty(int n) {
		if (n == 1)
			return n;
		else
			return n * recursiveFaculty(n - 1);
	}

	/*
	 * Aufgabe 6
	 */
	private static int iterativeFibonacci(int n) {
		if (n == 1 || n == 2)
			return 1;

		int f_2 = 1;
		int f_1 = 1;
		int f = f_1 + f_2;

		for (int i = 3; i < n; i++) {
			f_2 = f_1;
			f_1 = f;
			f = f_1 + f_2;
		}
		return f;
	}

	private static int recursiveFibonacci(int n) {
		if (n == 1 || n == 2)
			return 1;
		else
			return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
	}

	/*
	 * Aufgabe 7
	 */
	private static int stringToIntA(String txt) {
		try {
			return Integer.parseInt(txt);
		} catch (NumberFormatException nfex) {
			nfex.printStackTrace();
			System.out.println("Das war keine Zahl");
		}
		return -1;
	}

	private static int stringToIntB(String txt) {
		try {
			return Integer.parseInt(txt);
		} catch (NumberFormatException nfex) {
			nfex.printStackTrace();
			System.out.println("Das war keine Zahl");
			throw new NumberFormatException();
		}
	}

	private static int stringToIntC(String txt) throws NumberFormatException {
		return Integer.parseInt(txt);
	}

	/*
	 * Aufgabe 8
	 */
	private static void divide() {
		boolean active = true;
		System.out.println("Willkommen!");
		while (active) {
			try {
				System.out.print("Gib die erste Zahl ein: ");
				int dividend = sc.nextInt();
				System.out.print("Gib die zweite Zahl ein: ");
				int divisor = sc.nextInt();

				if (dividend < 0 || divisor < 0)
					throw new ArithmeticException("number < 0");

				System.out.println(dividend + " / " + divisor + " = " + dividend / divisor);

				System.out.print("Willst Du noch eine Division durchführen [j/n]? ");
				String input = sc.next();
				if (input.equals("n"))
					active = false;
				else if (!input.equals("j"))
					throw new UnsupportedOperationException();

			} catch (java.util.InputMismatchException imex) {
				System.out.println("EINGABEFEHLER - ich kann nur ganze Zahlen dividieren!");
				sc.next();
			} catch (UnsupportedOperationException uoex) {
				System.out.println("EINGABEFEHLER - Programm wird neu gestartet!");
			} catch (ArithmeticException uoex) {
				if (uoex.getMessage().equals("number < 0")) {
					System.out.println("Fehler - Mind. eine der beiden Zahlen wahr < 0"); 
				} else if (uoex.getMessage().equals("/ by zero")) {
					System.out.println("FEHLER - Division durch 0!");
				}
			}
		}
		System.out.println("Auf Wiedersehen!");
	}

}
