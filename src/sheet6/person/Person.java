/**
 * 
 */
package sheet6.person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author bejahrer
 *
 */
public class Person {

	private static LinkedList<Person> allPersons = new LinkedList<>();

	private static File savedData = new File("person_data.txt");

	private String firstname;
	private String lastname;
	private int birthYear;
	private Person mother;
	private Person father;

	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthYear = 0;
		this.allPersons.add(this);
	}

	public Person(String firstname, String lastname, int birthYear) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthYear = birthYear;
		this.allPersons.add(this);
	}

	public String toString() {
		return String.format("%s %s %s", firstname, lastname, (birthYear != 0 ? "(" + birthYear + ")" : ""));
	}

	public static LinkedList<Person> getAllPersons() {
		return allPersons;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) throws IllegalArgumentException {
		if (mother.getBirthYear() < this.birthYear || this.birthYear == 0)
			this.mother = mother;
		else
			throw new IllegalArgumentException("Wrong age for mother!");
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) throws IllegalArgumentException {
		if (father.getBirthYear() < this.birthYear || this.birthYear == 0)
			this.father = father;
		else
			throw new IllegalArgumentException("Wrong age for father!");
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public ArrayList<Person> getParents() {
		ArrayList<Person> parents = new ArrayList<Person>();
		parents.add(mother);
		parents.add(father);
		return parents;
	}

	public ArrayList<Person> getGrandparents() {
		ArrayList<Person> grandParents = new ArrayList<Person>();
		grandParents.addAll(mother.getParents());
		grandParents.addAll(father.getParents());
		return grandParents;
	}

	public ArrayList<Person> getAncestors() {
		ArrayList<Person> ancestors = new ArrayList<>();
		if (this.mother != null)
			ancestors.addAll(findAncestors(this.mother, new ArrayList<Person>()));
		if (this.father != null)
			ancestors.addAll(findAncestors(this.father, new ArrayList<Person>()));
		return ancestors;
	}

	private ArrayList<Person> findAncestors(Person person, ArrayList<Person> ancestors) {
		if (person.getMother() != null) {
			findAncestors(person.getMother(), ancestors);
		}

		if (person.father != null) {
			findAncestors(person.getFather(), ancestors);
		}

		ancestors.add(person);
		return ancestors;
	}

	public ArrayList<Person> getSiblings() {
		ArrayList<Person> siblings = new ArrayList<>();
		for (Person person : allPersons) {
			if (((this.father != null && person.getFather() == this.father)
					|| this.mother != null && person.getMother() == this.mother) && person != this) {
				siblings.add(person);
			}
		}
		return siblings;
	}

	public static void loadDataFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(savedData));
			String line;
			while ((line = br.readLine()) != null) {
				String[] personData = line.split(" ");
				System.out.println(Arrays.toString(personData));
				// Load Person
				if (personData[0].equals("P")) {
					// Load person with fistname, lastname and birth year
					if (personData.length == 4) {
						new Person(personData[1], personData[2], Integer.parseInt(personData[3]));
						// Load person with firstname and lastname
					} else if (personData.length == 3)
						new Person(personData[1], personData[2]);
					// load relationships
				} else if (personData[0].equals("R")) {
					Person child = getAllPersons().get(Integer.parseInt(personData[1]));
					System.out.println("Child:" + child);
					// Person has a father
					if (personData[2].equals("T")) {
						System.out.println("Father: " + getAllPersons().get(Integer.parseInt(personData[3])));
						child.setFather(getAllPersons().get(Integer.parseInt(personData[3])));
					}
					// Person has a mother
					if (personData[4].equals("T")) {
						System.out.println("Mother: " + getAllPersons().get(Integer.parseInt(personData[5])));
						child.setMother(getAllPersons().get(Integer.parseInt(personData[5])));
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Fehler beim Laden der Daten!");
		}
	}

	public static void saveData() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(savedData));
			// Store all persons
			for (Person person : getAllPersons()) {
				bw.write(
						"P " + person.getFirstname() + " " + person.getLastname() + " " + person.getBirthYear() + "\n");
			}

			// Store all relationships
			int i = 0;
			for (Person person : getAllPersons()) {
				String dataEntry = "R " + i;
				if (person.getFather() != null)
					dataEntry += " T " + getId(person.getFather());
				else
					dataEntry += " F X";
				if (person.getMother() != null)
					dataEntry += " T " + getId(person.getMother());
				else
					dataEntry += " F X";
				bw.write(dataEntry + "\n");
				i++;
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Speichern der Daten!");
		}
	}

	private static int getId(Person person) {
		int i = 0;
		boolean found = false;
		while (i < getAllPersons().size() && !found) {
			if (person == getAllPersons().get(i)) {
				found = true;
				continue;
			}
			i++;
		}
		return i;
	}

}
