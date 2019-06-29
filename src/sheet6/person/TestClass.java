package sheet6.person;

import java.util.ArrayList;

/**
 * @author bejahrer
 *
 */
public class TestClass {
	public static void main(String[] args) {

		System.out.println("get all persons: " + Person.getAllPersons());

		Person p = new Person("Albert", "Schweitzer", 1875);
		Person p2 = new Person("Steve", "Wozniak");

		System.out.println(p);
		System.out.println(p2);

		Person ae = new Person("Albert", "Einstein", 1879);
		Person pk = new Person("Pauline", "Koch");
		Person he = new Person("Hermann", "Einstein", 1847);
		ae.setMother(pk);
		ae.setFather(he);
		System.out.println("Mother of " + ae + ": " + ae.getMother());
		System.out.println("Father of " + ae + ": " + ae.getFather());

		// Pauline Koch's parents
		Person jd = new Person("Julius", "Dörzbacher", 1816);
		Person jb = new Person("Jette", "Bernheimer", 1825);
		pk.setMother(jb);
		pk.setFather(jd);

		// Hermann Einstein's parents
		Person aes = new Person("Abraham", "Einstein", 1808);
		Person hm = new Person("Helene", "Moos", 1814);
		he.setMother(hm);
		he.setFather(aes);

		ArrayList<Person> parents = ae.getParents();
		for (Person parent : parents) {
			System.out.println(String.format("%s is an parent af %s", parent, ae));
		}
		System.out.println();

		ArrayList<Person> grandParents = ae.getGrandparents();
		for (Person grandParent : grandParents) {
			System.out.println(String.format("%s is an grandparent af %s", grandParent, ae));
		}
		System.out.println();

		ArrayList<Person> ancestors = ae.getAncestors();
		for (Person ancestor : ancestors) {
			System.out.println(String.format("%s is an ancestor af %s", ancestor, ae));
		}

		System.out.println("\nGet all persons: " + Person.getAllPersons());

		// Albert Einstein's sister
		Person me = new Person("Maja", "Einstein", 1881);
		me.setMother(pk);
		me.setFather(he);

		System.out.println("\nSibling(s) of " + ae + " are/is: " + ae.getSiblings());

	}
}
