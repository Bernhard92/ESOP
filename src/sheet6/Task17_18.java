/**
 * 
 */
package sheet6;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author bejahrer
 *
 */
public class Task17_18 {

	private static List<Integer> myList = new LinkedList<Integer>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("insert n: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			myList.add(i);
		}
		System.out.println(myList);
		printList(myList);
	}

	public static void printList(List<Integer> list) {
		System.out.println("Print with for-loop");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("Print with forEach-loop");
		for (int entry : list) {
			System.out.println(entry);
		}

		System.out.println("Print with while and iterator");
		ListIterator<Integer> iterator = list.listIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
