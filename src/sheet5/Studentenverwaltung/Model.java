package sheet5.Studentenverwaltung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Model {

	private HashMap<String, String> students;
	private File savedData; 


	public Model() {
		savedData = new File("data.txt");
		students = new HashMap<>(); 
		
		if (savedData.exists())
			loadDataFromFile(savedData);			
			
	}

	public void addStudent(String matrNr, String name) {
		students.put(matrNr, name);
		System.out.println("Neuen Eintrag hinzugefügt");
	}

	public void printName(String matrNr) {
		System.out.println("Name: " + students.get(matrNr));
	}

	public void printAllStudents() {
		for (Map.Entry<String, String> e : students.entrySet())
			System.out.println("Matrikelnummer: " + e.getKey() + " Name: " + e.getValue());
	}

	public void deleteStudent(String matrNr) {
		System.out.println("Lösche " + students.get(matrNr) + "...");
		students.remove(matrNr);

	}

	private void loadDataFromFile(File savedData) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(savedData));
			String line;
			while ((line = br.readLine()) != null) {
				String[] studentData = line.split(" ");
				addStudent(studentData[0], studentData[1]);
			}
		} catch (IOException e) {
			System.out.println("Fehler beim Laden der Daten!");
		}
	}

	public void saveData() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(savedData));
			for (Map.Entry<String, String> e : students.entrySet())
				bw.write(e.getKey() + " " + e.getValue()+"\n");
			bw.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Speichern der Daten!");
		}
	}

}
