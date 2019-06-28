package sheet5.FileFinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Aufgabe 6
 */
public class DirectoryInfo {

	public static void main(String[] args) {
		File directory = new File("C:\\Users\\bejahrer\\test");
		File[] files = directory.listFiles();

		for (File file : files) {
			if (file.isFile())
				System.out.println(file);
			else if (file.isDirectory()) {
				System.out.println(file + " [" + files.length + "][" + countAllFiles(files) + "]");
			}
		}

		recursiveFind(directory, "file.txt");

		recursiveGrep(directory, "find me");

		fillWithFiles(new File("C:\\Users\\bejahrer\\test\\f1"), new File("C:\\Users\\bejahrer\\test\\f2"));

	}

	private static int countAllFiles(File[] files) {
		int sum = 0;
		for (File file : files) {
			if (file.isDirectory())
				sum += countAllFiles(file.listFiles());
			else
				sum++;
		}
		return sum;
	}

	private static void recursiveFind(File folder, String searchName) {
		for (File file : folder.listFiles()) {
			if (file.getName().equals(searchName))
				System.out.println("Found file at: " + file.getAbsolutePath());
			else if (file.isDirectory())
				recursiveFind(file, searchName);
		}
	}

	private static void recursiveGrep(File folder, String searchText) {
		for (File file : folder.listFiles()) {
			if (file.isFile()) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String line;
					while ((line = br.readLine()) != null) {
						if (line.contains(searchText))
							System.out.println("Found file at: " + file.getAbsolutePath());
					}
				} catch (IOException e) {
					System.out.println("Fehler beim Laden der Daten!");
				}
			} else if (file.isDirectory())
				recursiveGrep(file, searchText);
		}
	}

	private static void synchronize(File folder1, File folder2) {
		HashMap<String, File> filesFolder1 = fillWithFiles(folder1);
		HashMap<String, File> filesFolder2 = fillWithFiles(folder2);
//			
//		for (Map.Entry<String, File> e : filesFolder1.entrySet())
//			if(!filesFolder2.containsKey(e.getKey())){
//				filesFolder2.put
//			}

		filesFolder1.putAll(filesFolder2);
		filesFolder2.putAll(filesFolder1);

	}

//	private static void fillWithFiles(File folder, File folder2) {
//		for (File file : folder.listFiles()) {
//			if (file.isFile()) {
//				try {
//					Files.copy(file.toPath()));
//					
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
	

	private static HashMap<String, File> fillWithFiles(File folder) {
		HashMap<String, File> filesFolder = new HashMap<>();
		for (File file : folder.listFiles()) {
			if (file.isFile()) {
				filesFolder.put(file.getName(), file);
			}
		}
		return filesFolder;
	}

}
