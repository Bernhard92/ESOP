package sheet6;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bejahrer
 *
 */
public class DirectoryInfo {

	public static void main(String[] args) {
		File directory = new File("C:\\Users\\bejahrer\\test");

		// Task 6
		directoryInfo(directory);

		// Task 7
		recursiveFind(directory, "file.txt");

		// Task 8
		recursiveGrep(directory, "find me");

		// Task 9
		synchronize(new File("C:\\Users\\bejahrer\\Test\\f1"), new File("C:\\Users\\bejahrer\\Test\\f2"));

	}

	/*
	 * Task 6
	 */
	private static void directoryInfo(File directory) {
		File[] files = directory.listFiles();

		for (File file : files) {
			if (file.isFile())
				System.out.println(file);
			else if (file.isDirectory()) {
				System.out.println(file + " [" + files.length + "][" + countAllFiles(files) + "]");
			}
		}
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

	/*
	 * Task 7
	 */
	private static void recursiveFind(File folder, String searchName) {
		for (File file : folder.listFiles()) {
			if (file.getName().equals(searchName))
				System.out.println("Found file at: " + file.getAbsolutePath());
			else if (file.isDirectory())
				recursiveFind(file, searchName);
		}
	}

	/*
	 * Task 8
	 */
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

	/*
	 * Task 9
	 */
	private static void synchronize(File folder1, File folder2) {
		HashMap<String, File> filesFolder1 = fillWithFiles(folder1);
		HashMap<String, File> filesFolder2 = fillWithFiles(folder2);

		copyFiles(filesFolder1, filesFolder2, folder2);
		copyFiles(filesFolder2, filesFolder1, folder1);
	}

	private static void copyFiles(HashMap<String, File> folderSource, HashMap<String, File> folderDest, File dest) {
		for (Map.Entry<String, File> sourceFileEntry : folderSource.entrySet()) {
			if (!folderDest.containsKey(sourceFileEntry.getKey())) {
				try {
					String destPath = dest.getAbsolutePath() + "\\" + sourceFileEntry.getKey();
					System.out.println(destPath);
					Files.copy(sourceFileEntry.getValue().toPath(), (new File(destPath)).toPath(),
							StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

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
