
package sheet6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author bejahrer
 *
 */
public class Task1 {

	public static void main(String[] args) {
		File file = new File("test.txt");
		PrintWriter out = null;

		try {
			out = new PrintWriter("test.txt");
			out.print("My Name");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}

}
