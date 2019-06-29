/**
 * 
 */
package sheet6.filmverwaltung;

/**
 * @author bejahrer
 *
 */
public class DVD {

	private String title;
	private int releaseYear;

	public DVD(String title, int releaseYear) {
		this.title = title;
		this.releaseYear = releaseYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String toString() {
		return this.title + " (" + this.releaseYear + ")";
	}

}
