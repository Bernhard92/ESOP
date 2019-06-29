/**
 * 
 */
package sheet6.person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author bejahrer
 *
 */
public class Main {

	
	public static void main(String[] args) {
		Person.loadDataFromFile();
		System.out.println("Wellcome! \n"
				+ "Command list:\n"
				+ "new <Vorname> <Nachname>\n"
				+ "new <Vorname> <Nachname> <GebJahr>\n"
				+ "father <lfdNr. Kind> <lfdNr. Vater>\n"
				+ "mother <lfdNr. Kind> <lfdNr. Mutter>\n"
				+ "ancestors <lfdNr.>\n"
				+ "siblings <lfdNr.>\n"				
				+ "list\n"
				+ "quit");
		
		Scanner sc = new Scanner(System.in); 
		boolean active = true; 
		while(active) {
			String input = sc.nextLine();
			String[] command =  input.split(" "); 
			switch (command[0]) {
				case "new":
					if (command.length == 3)
						new Person(command[1], command[2]);
					else 
						new Person(command[1], command[2], Integer.parseInt(command[3]));
					System.out.println("Added new person with key: " + (Person.getAllPersons().size()-1));
					break;
				case "father":
					Person child = Person.getAllPersons().get(Integer.parseInt(command[1]));
					Person father = Person.getAllPersons().get(Integer.parseInt(command[2]));
					child.setFather(father);
					System.out.println(String.format("Addded %s as father of %s", father, child));
					break; 
				case "mother":
					Person child_ = Person.getAllPersons().get(Integer.parseInt(command[1]));
					Person mother = Person.getAllPersons().get(Integer.parseInt(command[2]));
					child_.setMother(mother);
					System.out.println(String.format("Addded %s as mother of %s", mother, child_));
					break;  
				case "ancestors":
					Person person = Person.getAllPersons().get(Integer.parseInt(command[1]));
					ArrayList<Person> ancestors = person.getAncestors(); 
					for(Person ancestor : ancestors) {
						System.out.println(String.format("%s is an ancestor af %s", ancestor, person));
					}
					break; 
				case "siblings":
					Person person_ = Person.getAllPersons().get(Integer.parseInt(command[1]));
					ArrayList<Person> siblings = person_.getSiblings();
					for(Person sibling : siblings) {
						System.out.println(String.format("%s is an sibling af %s", sibling, person_));
					}
					break;
				case "list":
					LinkedList<Person> allPersons = Person.getAllPersons(); 
					for(Person p : allPersons) {
						System.out.println(allPersons.indexOf(p) + ": " + p);
					}
					break; 
				case "quit":
					active = false; 
					System.out.println("Shutting down...");
					Person.saveData();
					break; 
				default:
					System.out.println("Command not found!");	
					break; 
			}
		}
	}
}
