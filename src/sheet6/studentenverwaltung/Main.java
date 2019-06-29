package sheet6.studentenverwaltung;

import java.util.Scanner;

/**
 * @author bejahrer
 *
 */
public class Main{
	
	
	public static void main(String[] args) {
		Model model = new Model(); 
		System.out.println("Studentenverwaltung gestartet! \n"
				+ "Mögliche Befehle:\n"
				+ "new <Matrikelnummer> <Name>\n"
				+ "name <Matrikelnummer>\n"
				+ "del <Matrikelnummer> \n"
				+ "list\n"
				+ "quit");
		
		Scanner sc = new Scanner(System.in); 
		boolean active = true; 
		while(active) {
			String input = sc.nextLine();
			String[] command =  input.split(" "); 
			switch (command[0]) {
				case "new": 
					model.addStudent(command[1], command[2]);
					break;
				case "name":
					model.printName(command[1]);
					break; 
				case "del":
					model.deleteStudent(command[1]); 
					break; 
				case "list":
					model.printAllStudents(); 
					break; 
				case "quit":
					model.saveData();
					active = false; 
					break; 
				default:
					System.out.println("Befehl nicht gefunden!");
					break;
					
			}
		}
	}
	
	

}
