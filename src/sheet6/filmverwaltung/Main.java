/**
 * 
 */
package sheet6.filmverwaltung;

import java.util.ListIterator;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author bejahrer
 *
 */
public class Main {

	private static Vector<DVD> movies = new Vector<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Wellcome! \n" + "Command list:\n" + "add\n" + "list <(optinal) release year>");

		boolean active = true;
		while (active) {
			String input = sc.nextLine();
			String[] command = input.split(" ");
			switch (command[0]) {
			case "add":
				addDVD(movies);
				System.out.println("DVD added successfully");
				break;
			case "list":
				if (command.length == 2)
					showDVDList(movies, Integer.parseInt(command[1]));
				else
					showDVDList(movies, 0);
				break;
			case "quit":
				active = false;
				System.out.println("Shutting down...");
				break;
			default:
				System.out.println("Command not found!");
				break;
			}
		}
	}

	public static void addDVD(Vector<DVD> vec) {
		System.out.print("***ADD NEW DVD*** <current stock: " + movies.size() + ">\n" + "Please insert title: ");
		String title = sc.nextLine();
		System.out.print("Now insert release year: ");
		int releaseYear = Integer.parseInt(sc.nextLine()); // nextLine instead of int to flush buffer

		movies.add(new DVD(title, releaseYear));
	}

	public static void showDVDList(Vector<DVD> vec, int yearfilter) {
		ListIterator<DVD> iterator = movies.listIterator();
		while (iterator.hasNext()) {
			DVD dvd = iterator.next();
			if ((yearfilter != 0 && dvd.getReleaseYear() == yearfilter) || yearfilter == 0) {
				System.out.println(dvd);
			}
		}
	}

	public static void addString() {
		// movies.add("test");
	}
}
